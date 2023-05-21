package com.uas.config;


import com.uas.event.AutoAckStreamConsumeListener;
import com.uas.service.StreamRedisQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.RedisStreamCommands;
import org.springframework.data.redis.connection.stream.*;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamMessageListenerContainer;
import org.springframework.util.ErrorHandler;

import java.time.Duration;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

@Configuration
public class RedisStreamConfiguration {
    @Autowired
    private RedisConnectionFactory redisConnectionFactory;
    @Autowired
    private AutoAckStreamConsumeListener autoAckStreamConsumeListener;
    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    @Bean(initMethod = "start", destroyMethod = "stop")
    public StreamMessageListenerContainer<String, MapRecord<String, String, String>> streamMessageListenerContainer() {
        AtomicInteger index = new AtomicInteger(1);
        int processors = Runtime.getRuntime().availableProcessors();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(processors, processors, 0, TimeUnit.SECONDS,
                new LinkedBlockingDeque<>(), r -> {
            Thread thread = new Thread(r);
            thread.setName("async-stream-consumer-" + index.getAndIncrement());
            thread.setDaemon(true);
            return thread;
        });
        StreamMessageListenerContainer.StreamMessageListenerContainerOptions<String, MapRecord<String, String, String>> options =
                StreamMessageListenerContainer.StreamMessageListenerContainerOptions
                        .builder()
                        // 一次最多获取多少条消息
                        .batchSize(3)
                        // 运行 Stream 的 poll task
                        .executor(executor)
                        // Stream 中没有消息时，阻塞多长时间，需要比 `spring.redis.timeout` 的时间小
                        .pollTimeout(Duration.ofSeconds(3))
                        // 获取消息的过程或获取到消息给具体的消息者处理的过程中，发生了异常的处理
                        .errorHandler(new ErrorHandler() {
                            @Override
                            public void handleError(Throwable t) {
                                System.out.println("出现异常就来这里了" + t);
                            }
                        })
                        .build();

        StreamMessageListenerContainer<String, MapRecord<String, String, String>> streamMessageListenerContainer =
                StreamMessageListenerContainer.create(redisConnectionFactory, options);
        // 独立消费

        // 消费组A,自动ack
        // 从消费组中没有分配给消费者的消息开始消费
        if (!isStreamGroupExists(StreamRedisQueue.KEY,AutoAckStreamConsumeListener.GROUP)){
            redisTemplate.opsForStream().createGroup(StreamRedisQueue.KEY,AutoAckStreamConsumeListener.GROUP);
        }
        streamMessageListenerContainer.receiveAutoAck(Consumer.from(AutoAckStreamConsumeListener.GROUP, "AutoAckConsumer"),
                StreamOffset.create(StreamRedisQueue.KEY, ReadOffset.lastConsumed()), autoAckStreamConsumeListener);

        return streamMessageListenerContainer;

    }

    /**
     * 判断该消费组是否存在
     * @param streamKey
     * @param groupName
     * @return
     */
    public boolean isStreamGroupExists(String streamKey, String groupName) {
        RedisStreamCommands commands = redisConnectionFactory.getConnection().streamCommands();
        //首先检查Stream Key是否存在，否则下面代码可能会因为尝试检查不存在的Stream Key而导致异常
        if (!redisTemplate.hasKey(streamKey)){
            return false;
        }
        //获取streamKey下的所有groups
        StreamInfo.XInfoGroups xInfoGroups = commands.xInfoGroups(streamKey.getBytes());
        AtomicBoolean exists= new AtomicBoolean(false);
        xInfoGroups.forEach(xInfoGroup -> {
            if (xInfoGroup.groupName().equals(groupName)){
                exists.set(true);
            }
        });

        return exists.get();
    }
}