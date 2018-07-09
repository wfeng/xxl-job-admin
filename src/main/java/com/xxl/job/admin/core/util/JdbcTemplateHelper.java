package com.xxl.job.admin.core.util;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;

import java.util.Map;
import java.util.Properties;

/**
 * jdbc操作类
 * <p>
 * Created by wfeng on 2018/7/6.
 */
public class JdbcTemplateHelper {

    /**
     * 执行更新操作
     *
     * @param properties 数据库连接配置
     * @param sql        执行语句
     * @param paramMap   参数
     * @return
     */
    public static int update(Properties properties, String sql, Map<String, ?> paramMap) {

        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(properties.getProperty("url"));
        dataSource.setUsername(properties.getProperty("user"));
        dataSource.setPassword(properties.getProperty("password"));
        dataSource.setDriverClassName(properties.getProperty("driver"));
//        dataSource.setConnectProperties(properties);
        int ret = new NamedParameterJdbcTemplate(dataSource).update(sql, paramMap);
        dataSource.close();
        return ret;
    }

}
