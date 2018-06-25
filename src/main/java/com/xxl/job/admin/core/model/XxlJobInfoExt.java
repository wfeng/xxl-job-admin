package com.xxl.job.admin.core.model;

/**
 * xxl-job info
 *
 * @author xuxueli  2016-1-12 18:25:49
 */
public class XxlJobInfoExt {

    private int id;                // 主键ID
    private int jobId;                // Job主键ID
    private String calculateModel;        // 计算模型json大对象

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
    }

    public String getCalculateModel() {
        return calculateModel;
    }

    public void setCalculateModel(String calculateModel) {
        this.calculateModel = calculateModel;
    }
}
