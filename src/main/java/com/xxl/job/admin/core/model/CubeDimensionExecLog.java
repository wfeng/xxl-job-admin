package com.xxl.job.admin.core.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 立方维度执行日志信息表
 */
public class CubeDimensionExecLog {

    private int id;    //主键ID
    private String cubeId;   // 立方编号
    private int dimId;    //维度编号
    private int jobId;  //任务编号
    private LocalDateTime statisticalTime;  //统计时间
    private LocalDate businessStartTime;       //业务开始时间
    private LocalDate businessEndTime;          //业务结束时间
    private int jobLogId;      //任务执行日志编号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCubeId() {
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public int getDimId() {
        return dimId;
    }

    public void setDimId(int dimId) {
        this.dimId = dimId;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public int getJobLogId() {
        return jobLogId;
    }

    public void setJobLogId(int jobLogId) {
        this.jobLogId = jobLogId;
    }

    public LocalDateTime getStatisticalTime() {
        return statisticalTime;
    }

    public void setStatisticalTime(LocalDateTime statisticalTime) {
        this.statisticalTime = statisticalTime;
    }

    public LocalDate getBusinessStartTime() {
        return businessStartTime;
    }

    public void setBusinessStartTime(LocalDate businessStartTime) {
        this.businessStartTime = businessStartTime;
    }

    public LocalDate getBusinessEndTime() {
        return businessEndTime;
    }

    public void setBusinessEndTime(LocalDate businessEndTime) {
        this.businessEndTime = businessEndTime;
    }
}
