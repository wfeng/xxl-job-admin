package com.xxl.job.admin.core.model;

/**
 * 立方源表信息表
 */
public class CubeSourceTable {

    private int id;                // 主键ID 自增
    private String cubeId;                // 立方编号
    private int primaryTable;                // 是否为主数据
    private String tableName;                // 表名
    private String incrFieldName;        //增量字段
    private int parallelism;        // 并行度
    private String parallelismFieldName;   //并行分区字段名
    private int parallelismType;        // 并行分区类型

    private String jdbcUrl;   //数据库连接
    private String jdbcUsername;   //账户名
    private String jdbcPassword;   //密码
    private String jdbcDriver;   //数据库连接驱动
    private int jdbcFetchsize;   //批量读取数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCubeId() {
        return cubeId;
    }

    public void setCubeId(String cubeId) {
        this.cubeId = cubeId;
    }

    public int getPrimaryTable() {
        return primaryTable;
    }

    public void setPrimaryTable(int primaryTable) {
        this.primaryTable = primaryTable;
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

    public int getParallelismType() {
        return parallelismType;
    }

    public void setParallelismType(int parallelismType) {
        this.parallelismType = parallelismType;
    }

    public String getJdbcUrl() {
        return jdbcUrl;
    }

    public void setJdbcUrl(String jdbcUrl) {
        this.jdbcUrl = jdbcUrl;
    }

    public String getJdbcUsername() {
        return jdbcUsername;
    }

    public void setJdbcUsername(String jdbcUsername) {
        this.jdbcUsername = jdbcUsername;
    }

    public String getJdbcPassword() {
        return jdbcPassword;
    }

    public void setJdbcPassword(String jdbcPassword) {
        this.jdbcPassword = jdbcPassword;
    }

    public String getJdbcDriver() {
        return jdbcDriver;
    }

    public void setJdbcDriver(String jdbcDriver) {
        this.jdbcDriver = jdbcDriver;
    }

    public int getJdbcFetchsize() {
        return jdbcFetchsize;
    }

    public void setJdbcFetchsize(int jdbcFetchsize) {
        this.jdbcFetchsize = jdbcFetchsize;
    }
}
