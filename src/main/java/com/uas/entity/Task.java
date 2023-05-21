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
 * 活动任务
 * </p>
 *
 * @author tallon
 * @since 2023-05-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("task")
public class Task {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 任务编码
     */
    @TableField("key_code")
    private String keyCode;

    /**
     * 活动编码
     */
    @TableField("activity_key_code")
    private String activityKeyCode;

    /**
     * 奖励规则
     */
    @TableField("reward_rule")
    private String rewardRule;

    /**
     * 匹配规则
     */
    @TableField("match_rule")
    private String matchRule;

    /**
     * 处理规则
     */
    @TableField("process_rule")
    private String processRule;

    /**
     * 状态
     */
    @TableField("status")
    private String status;

    /**
     * 扩展字段
     */
    @TableField("ext")
    private String ext;

    /**
     * 操作人
     */
    @TableField("operator")
    private String operator;

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
