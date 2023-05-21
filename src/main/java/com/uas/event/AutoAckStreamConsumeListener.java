package com.uas.event;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.stream.MapRecord;
import org.springframework.data.redis.connection.stream.RecordId;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.stream.StreamListener;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class AutoAckStreamConsumeListener implements StreamListener<String, MapRecord<String, String, String>> {
    //分组名
    public static final String GROUP = "autoack_stream";
    @Autowired
    private RedisTemplate<String, String> redisTemplate;
    @Override
    public void onMessage(MapRecord<String, String, String> message) {
        String stream = message.getStream();
        RecordId id = message.getId();
        Map<String, String> map = message.getValue();
        System.out.println("[自动ACK]接收到一个消息 stream:[" + stream + "],id:[" + id + "],value:[" + map + "]");
        redisTemplate.opsForStream().delete(GROUP, id.getValue());
    }
}
