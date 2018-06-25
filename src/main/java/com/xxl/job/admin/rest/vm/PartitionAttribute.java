package com.xxl.job.admin.rest.vm;

/**
 * 分区属性
 * <p>
 * Created by wfeng on 2018/6/14.
 */
public class PartitionAttribute {

    //分区字段名
    private String columnName;

    //分区类型 1-天 2-周 3-月 4-季度 5-年
    private Integer partitionType;

    //分区类型数
    private Integer partitionTypeNumber;

    //时间格式
    private String dateFormatter;

    //数据开始时间 yyyyMMdd
    private String startTime;

    //数据结束时间 yyyyMMdd
    private String endTime;

    //默认构造
    public PartitionAttribute() {
    }

    //分区简单构造 不分区只指定数据范围
    public PartitionAttribute(String columnName, String startTime, String endTime) {
        this.columnName = columnName;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    //分区构造 指定分区类型以及数据范围
    public PartitionAttribute(String columnName, Integer partitionType, Integer partitionTypeNumber, String startTime, String endTime) {
        this.columnName = columnName;
        this.partitionType = partitionType;
        this.partitionTypeNumber = partitionTypeNumber;
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public Integer getPartitionType() {
        return partitionType;
    }

    public void setPartitionType(Integer partitionType) {
        this.partitionType = partitionType;
    }

    public Integer getPartitionTypeNumber() {
        return this.partitionTypeNumber;
    }

    public void setPartitionTypeNumber(Integer partitionTypeNumber) {
        this.partitionTypeNumber = partitionTypeNumber;
    }

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getDateFormatter() {
        return dateFormatter;
    }

    public void setDateFormatter(String dateFormatter) {
        this.dateFormatter = dateFormatter;
    }

    @Override
    public String toString() {
        return "PartitionAttribute{" +
                "columnName='" + columnName + '\'' +
                ", partitionType=" + partitionType +
                ", partitionTypeNumber=" + partitionTypeNumber +
                ", dateFormatter='" + dateFormatter + '\'' +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                '}';
    }
}
