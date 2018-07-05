package com.xxl.job.admin.rest.vm;

import java.util.List;

/**
 * 计算模型定义
 * <p>
 * Created by wfeng on 2018/6/14.
 */
public class CalculateModel {

    //模型类型
    private String modelType;

    //源数据表列表
    private List<SourceTableAttribute> sourceTableList;

    //执行语句
    private String executeSql;

    //目标表
    private DimensionTableAttribute targetTable;

    public String getModelType() {
        return modelType;
    }

    public void setModelType(String modelType) {
        this.modelType = modelType;
    }

    public List<SourceTableAttribute> getSourceTableList() {
        return sourceTableList;
    }

    public void setSourceTableList(List<SourceTableAttribute> sourceTableList) {
        this.sourceTableList = sourceTableList;
    }

    public String getExecuteSql() {
        return executeSql;
    }

    public void setExecuteSql(String executeSql) {
        this.executeSql = executeSql;
    }

    public DimensionTableAttribute getTargetTable() {
        return targetTable;
    }

    public void setTargetTable(DimensionTableAttribute targetTable) {
        this.targetTable = targetTable;
    }
}
