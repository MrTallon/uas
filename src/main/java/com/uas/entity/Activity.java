package com.uas.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * <p>
 * 活动规则定义
 * </p>
 *
 * @author tallon
 * @since 2023-05-19
 */
//@ApiModel(value = "Activity对象", description = "活动规则定义")
public class Activity implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

//    @ApiModelProperty("活动编码")
    private String keyCode;

//    @ApiModelProperty("开始时间")
    private LocalDateTime startTime;

//    @ApiModelProperty("结束时间")
    private LocalDateTime endTime;

//    @ApiModelProperty("判断是否能够参加活动的处理器")
    private String processor;

//    @ApiModelProperty("判断是否能够参加活动的处理器参数")
    private String processorParams;

//    @ApiModelProperty("状态：PENDING,OPENED,CLOSED")
    private String status;

//    @ApiModelProperty("扩展字段")
    private String ext;

//    @ApiModelProperty("操作人")
    private String operator;

//    @ApiModelProperty("创建时间")
    private LocalDateTime createdAt;

//    @ApiModelProperty("更新时间")
    private LocalDateTime updatedAt;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKeyCode() {
        return keyCode;
    }

    public void setKeyCode(String keyCode) {
        this.keyCode = keyCode;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalDateTime endTime) {
        this.endTime = endTime;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getProcessorParams() {
        return processorParams;
    }

    public void setProcessorParams(String processorParams) {
        this.processorParams = processorParams;
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
        return "Activity{" +
        "id = " + id +
        ", keyCode = " + keyCode +
        ", startTime = " + startTime +
        ", endTime = " + endTime +
        ", processor = " + processor +
        ", processorParams = " + processorParams +
        ", status = " + status +
        ", ext = " + ext +
        ", operator = " + operator +
        ", createdAt = " + createdAt +
        ", updatedAt = " + updatedAt +
        "}";
    }
}
