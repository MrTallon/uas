package com.uas.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 活动任务
 * </p>
 *
 * @author tallon
 * @since 2023-05-20
 */
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 任务编码
     */
    private String keyCode;

    /**
     * 活动编码
     */
    private String activityKeyCode;

    /**
     * 奖励规则
     */
    private String rewardRule;

    /**
     * 匹配规则
     */
    private String matchRule;

    /**
     * 处理规则
     */
    private String processRule;

    /**
     * 状态
     */
    private String status;

    /**
     * 扩展字段
     */
    private String ext;

    /**
     * 操作人
     */
    private String operator;

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

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public String getActivityKeyCode() {
        return activityKeyCode;
    }

    public void setActivityKeyCode(String activityKeyCode) {
        this.activityKeyCode = activityKeyCode;
    }

    public String getRewardRule() {
        return rewardRule;
    }

    public void setRewardRule(String rewardRule) {
        this.rewardRule = rewardRule;
    }

    public String getMatchRule() {
        return matchRule;
    }

    public void setMatchRule(String matchRule) {
        this.matchRule = matchRule;
    }

    public String getProcessRule() {
        return processRule;
    }

    public void setProcessRule(String processRule) {
        this.processRule = processRule;
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

    public String getOperator() {
        return operator;
    }

    public void setOperator(String operator) {
        this.operator = operator;
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
        return "Task{" +
        "id = " + id +
        ", keyCode = " + keyCode +
        ", activityKeyCode = " + activityKeyCode +
        ", rewardRule = " + rewardRule +
        ", matchRule = " + matchRule +
        ", processRule = " + processRule +
        ", status = " + status +
        ", ext = " + ext +
        ", operator = " + operator +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
