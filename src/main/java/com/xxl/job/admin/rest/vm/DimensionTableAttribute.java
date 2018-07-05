package com.xxl.job.admin.rest.vm;

import org.apache.commons.lang3.StringUtils;

/**
 * 维度表属性
 * <p>
 * Created by wfeng on 2018/7/3.
 */
public class DimensionTableAttribute {

    //Jdbc属性
    private JdbcAttribute jdbcAttr;

    //表名
    private String tableName;

    //保存模式 1-Append/2-Overwrite/3-ErrorIfExists/4-Ignore
    private Integer saveMode;

    //执行语句
    private String executeSql;

    //维度表描述
    private String description;

    public JdbcAttribute getJdbcAttr() {
        return jdbcAttr;
    }

    public void setJdbcAttr(JdbcAttribute jdbcAttr) {
        this.jdbcAttr = jdbcAttr;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public Integer getSaveMode() {
        return saveMode;
    }

    public void setSaveMode(Integer saveMode) {
        this.saveMode = saveMode;
    }

    public String getExecuteSql() {
        return executeSql;
    }

    public void setExecuteSql(String executeSql) {
        this.executeSql = executeSql;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return "DimensionTableAttribute{" +
                "jdbcAttr=" + jdbcAttr +
                ", tableName='" + tableName + '\'' +
                ", saveMode=" + saveMode +
                ", executeSql='" + executeSql + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public boolean isEmpty() {
        return jdbcAttr.isEmpty()
                || StringUtils.isBlank(tableName)
                || StringUtils.isBlank(executeSql)
                || StringUtils.isBlank(description);
    }
}
