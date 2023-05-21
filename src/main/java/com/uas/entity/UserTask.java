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
 * 用户任务记录
 * </p>
 *
 * @author tallon
 * @since 2023-05-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_task")
public class UserTask {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

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
     * 用户任务开始时间
     */
    @TableField("open_time")
    private LocalDateTime openTime;

    /**
     * 用户任务完成时间
     */
    @TableField("complete_time")
    private LocalDateTime completeTime;

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
