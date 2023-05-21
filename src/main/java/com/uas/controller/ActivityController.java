package com.uas.controller;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.uas.entity.Activity;
import com.uas.entity.UserTask;
import com.uas.service.IActivityService;
import com.uas.service.IUserTaskService;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

/**
 * <p>
 * 活动 前端控制器
 * </p>
 *
 * @author tallon
 * @since 2023-05-21
 */
@RestController
@RequestMapping("/activity")
public class ActivityController {

    @Autowired
    private IActivityService activityService;

    @Autowired
    private IUserTaskService userTaskService;

    /**
     * 添加、修改 活动
     */
    @PutMapping("/upsert")
    private String participantsInActivity(@RequestBody UpsertReq req) {

        return "";
    }


    /**
     * 获取活动参与数据
     */
    @GetMapping("/participants")
    private String participantsInActivity(@RequestBody ParticipantsReq req) {

        if (StrUtil.isAllBlank(req.activityName, req.activityKeyCode)) {
            return "123";
        }

        if (StrUtil.isNotBlank(req.activityName)) {
            req.setActivityKeyCode(Optional.ofNullable(activityService.getOne(
                    Wrappers.<Activity>lambdaQuery().eq(Activity::getName, req.activityName))).map(Activity::getKeyCode).orElseThrow());
        }

        var count = userTaskService.count(Wrappers.<UserTask>lambdaQuery().eq(UserTask::getActivityKeyCode, req.getActivityKeyCode()));
        return "321";
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class UpsertReq {
        private String activityName;
    }

    @Data
    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    static class ParticipantsReq {

        /**
         * activityName
         */
        private String activityName;


        /**
         * activityKeyCode
         */
        private String activityKeyCode;
    }
}
