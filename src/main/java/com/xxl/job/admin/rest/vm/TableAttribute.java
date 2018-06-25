package com.xxl.job.admin.rest.vm;

/**
 * 表属性
 * <p>
 * Created by wfeng on 2018/6/14.
 */
public class TableAttribute {

    //Jdbc属性
    private JdbcAttribute jdbcAttr;

    //表名
    private String tableName;

    //子查询
    private String subQuery;

    //保存模式 1-Append/2-Overwrite/3-ErrorIfExists/4-Ignore
    private Integer saveMode;

    //分区属性
    private PartitionAttribute partitionAttr;

    //默认构造
    public TableAttribute() {
    }

    //源/目标表简单构造
    public TableAttribute(JdbcAttribute jdbcAttr, String tableName) {
        this.jdbcAttr = jdbcAttr;
        this.tableName = tableName;
    }

    //源表分区构造
    public TableAttribute(JdbcAttribute jdbcAttr, String tableName, PartitionAttribute partitionAttr) {
        this.jdbcAttr = jdbcAttr;
        this.tableName = tableName;
        this.partitionAttr = partitionAttr;
    }

    //源表子查询简单构造
    public TableAttribute(JdbcAttribute jdbcAttr, String tableName, String subQuery) {
        this.jdbcAttr = jdbcAttr;
        this.tableName = tableName;
        this.subQuery = subQuery;
    }

    //源表子查询分区构造
    public TableAttribute(JdbcAttribute jdbcAttr, String tableName, String subQuery, PartitionAttribute partitionAttr) {
        this.jdbcAttr = jdbcAttr;
        this.tableName = tableName;
        this.subQuery = subQuery;
        this.partitionAttr = partitionAttr;
    }

    //目标表指定保存模式构造
    public TableAttribute(JdbcAttribute jdbcAttr, String tableName, Integer saveMode) {
        this.jdbcAttr = jdbcAttr;
        this.tableName = tableName;
        this.saveMode = saveMode;
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

    public String getSubQuery() {
        return subQuery;
    }

    public void setSubQuery(String subQuery) {
        this.subQuery = subQuery;
    }

    public Integer getSaveMode() {
        return saveMode;
    }

    public void setSaveMode(Integer saveMode) {
        this.saveMode = saveMode;
    }

    public PartitionAttribute getPartitionAttr() {
        return partitionAttr;
    }

    public void setPartitionAttr(PartitionAttribute partitionAttr) {
        this.partitionAttr = partitionAttr;
    }

    @Override
    public String toString() {
        return "TableAttribute{" +
                "jdbcAttr=" + jdbcAttr +
                ", tableName='" + tableName + '\'' +
                ", subQuery='" + subQuery + '\'' +
                ", saveMode=" + saveMode +
                ", partitionAttr=" + partitionAttr +
                '}';
    }
}
