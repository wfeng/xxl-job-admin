package com.xxl.job.admin.rest.vm;

import io.swagger.annotations.ApiModelProperty;

/**
 * Created by wfeng on 2018/6/14.
 */
public class JobInfoResponseVM {

    //任务id
    @ApiModelProperty(value = "任务id")
    private int jobId;

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }
}
