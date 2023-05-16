package com.uas.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 用户任务记录
 * </p>
 *
 * @author tallon
 * @since 2023-05-20
 */
@TableName("user_task")
public class UserTask implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 任务编码
     */
    private String taskKeyCode;

    /**
     * 活动编码
     */
    private String activityKeyCode;

    /**
     * 状态
     */
    private String status;

    /**
     * 扩展字段
     */
    private String ext;

    /**
     * 用户任务开始时间
     */
    private LocalDateTime openTime;

    /**
     * 用户任务完成时间
     */
    private LocalDateTime completeTime;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getTaskKeyCode() {
        return taskKeyCode;
    }

    public void setTaskKeyCode(String taskKeyCode) {
        this.taskKeyCode = taskKeyCode;
    }

    public String getActivityKeyCode() {
        return activityKeyCode;
    }

    public void setActivityKeyCode(String activityKeyCode) {
        this.activityKeyCode = activityKeyCode;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getExt() {
        return ext;
    }

    public void setExt(String ext) {
        this.ext = ext;
    }

    public LocalDateTime getOpenTime() {
        return openTime;
    }

    public void setOpenTime(LocalDateTime openTime) {
        this.openTime = openTime;
    }

    public LocalDateTime getCompleteTime() {
        return completeTime;
    }

    public void setCompleteTime(LocalDateTime completeTime) {
        this.completeTime = completeTime;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(LocalDateTime createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    @Override
    public String toString() {
        return "UserTask{" +
        "id = " + id +
        ", userId = " + userId +
        ", taskKeyCode = " + taskKeyCode +
        ", activityKeyCode = " + activityKeyCode +
        ", status = " + status +
        ", ext = " + ext +
        ", openTime = " + openTime +
        ", completeTime = " + completeTime +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
