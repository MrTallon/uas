package com.uas.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 奖励记录
 * </p>
 *
 * @author tallon
 * @since 2023-05-20
 */
@TableName("reward_log")
public class RewardLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 对应的用户任务id
     */
    private Integer userTaskId;

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
     * 奖品类型
     */
    private String rewardType;

    /**
     * 奖品数量
     */
    private Integer amount;

    /**
     * 奖品信息
     */
    private String reward;

    /**
     * 奖励发放状态。PROGRESSING=发放中,DONE=发放成功，FAIL=发放失败
     */
    private String status;

    /**
     * 扩展字段
     */
    private String ext;

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

    public Integer getUserTaskId() {
        return userTaskId;
    }

    public void setUserTaskId(Integer userTaskId) {
        this.userTaskId = userTaskId;
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

    public String getRewardType() {
        return rewardType;
    }

    public void setRewardType(String rewardType) {
        this.rewardType = rewardType;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public String getReward() {
        return reward;
    }

    public void setReward(String reward) {
        this.reward = reward;
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
        return "RewardLog{" +
        "id = " + id +
        ", userTaskId = " + userTaskId +
        ", userId = " + userId +
        ", taskKeyCode = " + taskKeyCode +
        ", activityKeyCode = " + activityKeyCode +
        ", rewardType = " + rewardType +
        ", amount = " + amount +
        ", reward = " + reward +
        ", status = " + status +
        ", ext = " + ext +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
