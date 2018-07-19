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

    //执行语句select部分
    private String selectSql;

    //执行语句where部分
    private String whereSql;

    //执行语句groupBy部分
    private String groupbySql;

    //执行语句having部分
    private String havingSql;

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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSelectSql() {
        return selectSql;
    }

    public void setSelectSql(String selectSql) {
        this.selectSql = selectSql;
    }

    public String getWhereSql() {
        return whereSql;
    }

    public void setWhereSql(String whereSql) {
        this.whereSql = whereSql;
    }

    public String getGroupbySql() {
        return groupbySql;
    }

    public void setGroupbySql(String groupbySql) {
        this.groupbySql = groupbySql;
    }

    public String getHavingSql() {
        return havingSql;
    }

    public void setHavingSql(String havingSql) {
        this.havingSql = havingSql;
    }

    @Override
    public String toString() {
        return "DimensionTableAttribute{" +
                "jdbcAttr=" + jdbcAttr +
                ", tableName='" + tableName + '\'' +
                ", saveMode=" + saveMode +
                ", selectSql='" + selectSql + '\'' +
                ", whereSql='" + whereSql + '\'' +
                ", groupbySql='" + groupbySql + '\'' +
                ", havingSql='" + havingSql + '\'' +
                ", description='" + description + '\'' +
                '}';
    }

    public boolean isEmpty() {
        return jdbcAttr.isEmpty()
                || StringUtils.isBlank(tableName)
                || StringUtils.isBlank(selectSql)
//                || StringUtils.isBlank(whereSql) //不一定有，不校验此项
//                || StringUtils.isBlank(groupbySql) //不一定有，不校验此项
                || StringUtils.isBlank(description);
    }
}
