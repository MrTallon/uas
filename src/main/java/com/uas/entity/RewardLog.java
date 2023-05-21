package com.uas.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.time.LocalDateTime;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * <p>
 * 奖励记录
 * </p>
 *
 * @author tallon
 * @since 2023-05-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("reward_log")
public class RewardLog {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 对应的用户任务id
     */
    @TableField("user_task_id")
    private Integer userTaskId;

    /**
     * 用户id
     */
    @TableField("user_id")
    private String userId;

    /**
     * 任务编码
     */
    @TableField("task_key_code")
    private String taskKeyCode;

    /**
     * 活动编码
     */
    @TableField("activity_key_code")
    private String activityKeyCode;

    /**
     * 奖品类型
     */
    @TableField("reward_type")
    private String rewardType;

    /**
     * 奖品数量
     */
    @TableField("amount")
    private Integer amount;

    /**
     * 奖品信息
     */
    @TableField("reward")
    private String reward;

    /**
     * 奖励发放状态。PROGRESSING=发放中,DONE=发放成功，FAIL=发放失败
     */
    @TableField("status")
    private String status;

    /**
     * 扩展字段
     */
    @TableField("ext")
    private String ext;

    /**
     * 创建时间
     */
    @TableField(value = "created_at", fill = FieldFill.INSERT)
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    @TableField(value = "updated_at", fill = FieldFill.INSERT_UPDATE)
    private LocalDateTime updatedAt;
}
