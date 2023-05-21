package com.uas.controller;

import cn.hutool.core.date.DateUtil;
import com.uas.service.StreamRedisQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * <p>
 * 用户列表（临时使用，实际开发以用户中心为准） 前端控制器
 * </p>
 *
 * @author tallon
 * @since 2023-05-21
 */
@RestController
@RequestMapping("/user/test")
public class UserController {

    @Autowired
    private StreamRedisQueue streamRedisQueue;

    @GetMapping(value = "/test")
    public void test() {
        Map<String, String> map = new HashMap<>();
        map.put("刘德华", "大家好我是刘德华");
        map.put("周杰伦", "周杰伦");
        map.put("time", DateUtil.now());
        String result = streamRedisQueue.produce(map);
        System.out.println("controoler返回结果：" + result);
    }

}
