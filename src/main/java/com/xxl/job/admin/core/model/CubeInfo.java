package com.xxl.job.admin.core.model;

/**
 *
 *
 */
public class CubeInfo {

    private int cubeId;                // 立方编号
    private String cubeName;                // 立方名称
    private String triggerModel;        // 触发模式

    public int getCubeId() {
        return cubeId;
    }

    public void setCubeId(int cubeId) {
        this.cubeId = cubeId;
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
}
