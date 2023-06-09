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
 * 用户行为
 * </p>
 *
 * @author tallon
 * @since 2023-05-21
 */
@Getter
@Setter
@Accessors(chain = true)
@TableName("user_action")
public class UserAction {

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户行为源id，用于幂等控制
     */
    @TableField("request_id")
    private String requestId;

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
     * 事件类型
     */
    @TableField("action_code")
    private String actionCode;

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
}
