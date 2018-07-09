package com.xxl.job.admin.rest.vm;

import java.util.List;

/**
 * 创建立方任务请求对象
 * <p>
 * Created by wfeng on 2018/7/3.
 */
public class CreatCubeJobsRequestVM {

    public final static String EVERY_DAY = "EVERY_DAY";
    public final static String MANUAL = "MANUAL";

    //立方编号
    private String cudeId;

    //立方名称
    private String cubeName;

    //触发模式 每天 - EVERY_DAY, 手动 - MANUAL
    private String triggerModel;

    //源表列表
    private List<SourceTableAttribute> sourceTableList;

    //维度表列表
    private List<DimensionTableAttribute> dimensionTableList;

    public String getCudeId() {
        return cudeId;
    }

    public void setCudeId(String cudeId) {
        this.cudeId = cudeId;
    }

    public String getCubeName() {
        return cubeName;
    }

    public void setCubeName(String cubeName) {
        this.cubeName = cubeName;
    }

    public String getTriggerModel() {
        return triggerModel;
    }

    public void setTriggerModel(String triggerModel) {
        this.triggerModel = triggerModel;
    }

    public List<SourceTableAttribute> getSourceTableList() {
        return sourceTableList;
    }

    public void setSourceTableList(List<SourceTableAttribute> sourceTableList) {
        this.sourceTableList = sourceTableList;
    }

    public List<DimensionTableAttribute> getDimensionTableList() {
        return dimensionTableList;
    }

    public void setDimensionTableList(List<DimensionTableAttribute> dimensionTableList) {
        this.dimensionTableList = dimensionTableList;
    }

    @Override
    public String toString() {
        return "CreatCubeJobsRequestVM{" +
                "cudeId='" + cudeId + '\'' +
                ", cubeName='" + cubeName + '\'' +
                ", triggerModel='" + triggerModel + '\'' +
                ", sourceTableList=" + sourceTableList +
                ", dimensionTableList=" + dimensionTableList +
                '}';
    }
}
