package com.xxl.job.admin.rest.vm;

/**
 * 构建立方任务请求对象
 * <p>
 * Created by wfeng on 2018/7/5.
 */
public class BuildCubeJobsRequestVM {

    //立方编号
    private String cubeId;

    //维度表名
    private String dimTableName;

    //数据范围开始时间 yyyymmdd
    private String startTime;

    //数据范围结束时间 yyyymmdd
    private String endTime;

    public String getCubeId() {
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public String getDimTableName() {
        return dimTableName;
    }

    public void setDimTableName(String dimTableName) {
        this.dimTableName = dimTableName;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }
}
