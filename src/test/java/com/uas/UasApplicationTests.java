package com.uas;

import com.baomidou.mybatisplus.core.toolkit.Assert;
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
        Assert.isTrue(list.size() == 0,"==");
    }

}
