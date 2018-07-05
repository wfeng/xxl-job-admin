package com.xxl.job.admin.core.model;

import java.util.Date;

/**
 * 立方维度执行日志信息表
 */
public class CubeDimensionExecLog {

    private int id;    //主键ID
    private int cubeId;   // 立方编号
    private String dimId;    //维度编号
    private String jobId;  //任务编号
    private Date statisticalTime;  //统计时间
    private Date businessStartTime;       //业务开始时间
    private Date businessEndTime;          //业务结束时间
    private int jobLogId;      //任务执行日志编号

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCubeId() {
        return cubeId;
    }

    public void setCubeId(int cubeId) {
        this.cubeId = cubeId;
    }

    public String getDimId() {
        return dimId;
    }

    public void setDimId(String dimId) {
        this.dimId = dimId;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public int getJobLogId() {
        return jobLogId;
    }

    public void setJobLogId(int jobLogId) {
        this.jobLogId = jobLogId;
    }

    public Date getStatisticalTime() {
        return statisticalTime;
    }

    public void setStatisticalTime(Date statisticalTime) {
        this.statisticalTime = statisticalTime;
    }

    public Date getBusinessStartTime() {
        return businessStartTime;
    }

    public void setBusinessStartTime(Date businessStartTime) {
        this.businessStartTime = businessStartTime;
    }

    public Date getBusinessEndTime() {
        return businessEndTime;
    }

    public void setBusinessEndTime(Date businessEndTime) {
        this.businessEndTime = businessEndTime;
    }
}
