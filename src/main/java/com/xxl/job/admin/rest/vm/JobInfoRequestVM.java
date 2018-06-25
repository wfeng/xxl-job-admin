package com.xxl.job.admin.rest.vm;

import io.swagger.annotations.ApiModelProperty;

/**
 * 添加任务请求对象
 * <p>
 * Created by wfeng on 2018/6/14.
 */
public class JobInfoRequestVM {

    //任务描述
    @ApiModelProperty(value = "任务描述", required = true)
    private String jobDesc;

    //执行计划
    @ApiModelProperty(value = "执行计划Cron表达式", required = true)
    private String jobCron;

    //失败处理策略 FAIL_ALARM-失败警告/ FAIL_RETRY-失败重试
    @ApiModelProperty(value = "失败处理策略(FAIL_ALARM(失败警告)/FAIL_RETRY(失败重试))", required = true)
    private String executorFailStrategy;

    //责任人
    @ApiModelProperty(value = "责任人", required = true)
    private String author;

    //报警邮件 多个邮箱,分割
    @ApiModelProperty(value = "报警邮件 多个邮箱,分割", required = true)
    private String alarmEmail;

    //计算模型
    @ApiModelProperty(value = "计算模型", required = true)
    private CalculateModel calculateModel;

    public String getJobDesc() {
        return jobDesc;
    }

    public void setJobDesc(String jobDesc) {
        this.jobDesc = jobDesc;
    }

    public String getJobCron() {
        return jobCron;
    }

    public void setJobCron(String jobCron) {
        this.jobCron = jobCron;
    }

    public String getExecutorFailStrategy() {
        return executorFailStrategy;
    }

    public void setExecutorFailStrategy(String executorFailStrategy) {
        this.executorFailStrategy = executorFailStrategy;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getAlarmEmail() {
        return alarmEmail;
    }

    public void setAlarmEmail(String alarmEmail) {
        this.alarmEmail = alarmEmail;
    }

    public CalculateModel getCalculateModel() {
        return calculateModel;
    }

    public void setCalculateModel(CalculateModel calculateModel) {
        this.calculateModel = calculateModel;
    }
}
