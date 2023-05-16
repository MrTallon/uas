package com.uas;

import com.uas.service.IActivityService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class UasApplicationTests {

    @Autowired
    private IActivityService activityService;

    @Test
    void contextLoads() {
        var list = activityService.list();
        System.out.println(list);
    }

}
