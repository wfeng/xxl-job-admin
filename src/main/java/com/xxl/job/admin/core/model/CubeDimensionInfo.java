package com.xxl.job.admin.core.model;

/**
 * 立方维度表信息表
 */
public class CubeDimensionInfo {

    private int id;    //主键ID
    private int cubeId;   // 立方编号
    private String tableName;    //表名
    private String description;  //维度描述
    private String executeSql;  //执行语句
    private int saveMode;       //保存模式 1-Append/2-Overwrite/3-ErrorIfExists/4-Ignore
    private int jobId;          //任务Id
    private String jdbcUrl;      //数据库连接
    private String jdbcUsername;  //访问账号
    private String jdbcPassword;  //访问密码
    private String jdbcDriver;    //数据库连接驱动
    private int jdbcBatchsize;    //批量执行数量

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCubeId() {
        return cubeId;
    }

    public void setCubeId(int cubeId) {
        this.cubeId = cubeId;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getExecuteSql() {
        return executeSql;
    }

    public void setExecuteSql(String executeSql) {
        this.executeSql = executeSql;
    }

    public int getSaveMode() {
        return saveMode;
    }

    public void setSaveMode(int saveMode) {
        this.saveMode = saveMode;
    }

    public int getJobId() {
        return jobId;
    }

    public void setJobId(int jobId) {
        this.jobId = jobId;
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

    public int getJdbcBatchsize() {
        return jdbcBatchsize;
    }

    public void setJdbcBatchsize(int jdbcBatchsize) {
        this.jdbcBatchsize = jdbcBatchsize;
    }
}
