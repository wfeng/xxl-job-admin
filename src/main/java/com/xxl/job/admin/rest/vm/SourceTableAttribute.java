package com.xxl.job.admin.rest.vm;

import org.apache.commons.lang3.StringUtils;

/**
 * 表属性
 * <p>
 * Created by wfeng on 2018/6/14.
 */
public class SourceTableAttribute {

    //是否主表
    private boolean primaryTable;

    //Jdbc属性
    private JdbcAttribute jdbcAttr;

    //表名
    private String tableName;

    //增量字段
    private String incrFieldName;

    //并行度分区属性
    private ParallelAttribute parallelAttribute;

    //默认构造
    public SourceTableAttribute() {
    }

    public boolean isPrimaryTable() {
        return primaryTable;
    }

    public void setPrimaryTable(boolean primaryTable) {
        this.primaryTable = primaryTable;
    }

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

    public String getIncrFieldName() {
        return incrFieldName;
    }

    public void setIncrFieldName(String incrFieldName) {
        this.incrFieldName = incrFieldName;
    }

    public ParallelAttribute getParallelAttribute() {
        return parallelAttribute;
    }

    public void setParallelAttribute(ParallelAttribute parallelAttribute) {
        this.parallelAttribute = parallelAttribute;
    }

    @Override
    public String toString() {
        return "SourceTableAttribute{" +
                "primaryTable=" + primaryTable +
                ", jdbcAttr=" + jdbcAttr +
                ", tableName='" + tableName + '\'' +
                ", incrFieldName='" + incrFieldName + '\'' +
                ", parallelAttribute=" + parallelAttribute +
                '}';
    }

    public boolean isEmpty() {
        return jdbcAttr.isEmpty() || StringUtils.isBlank(tableName);
    }
}
