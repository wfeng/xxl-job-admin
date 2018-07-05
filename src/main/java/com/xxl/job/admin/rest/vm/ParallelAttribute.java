package com.xxl.job.admin.rest.vm;

/**
 * 分区属性
 * <p>
 * Created by wfeng on 2018/6/14.
 */
public class ParallelAttribute {

    //并行度 默认为20
    private int parallelism = 20;

    //并行分区字段名
    private String parallelismFieldName;

    //分区字段类型 1-时间类型 2-数字类型
    private Integer parallelismType;

    //默认构造
    public ParallelAttribute() {
    }

    public int getParallelism() {
        return parallelism;
    }

    public void setParallelism(int parallelism) {
        this.parallelism = parallelism;
    }

    public String getParallelismFieldName() {
        return parallelismFieldName;
    }

    public void setParallelismFieldName(String parallelismFieldName) {
        this.parallelismFieldName = parallelismFieldName;
    }

    public Integer getParallelismType() {
        return parallelismType;
    }

    public void setParallelismType(Integer parallelismType) {
        this.parallelismType = parallelismType;
    }
}
