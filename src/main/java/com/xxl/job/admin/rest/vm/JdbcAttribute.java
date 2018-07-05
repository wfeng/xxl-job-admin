package com.xxl.job.admin.rest.vm;

import org.springframework.util.StringUtils;

/**
 * Jdbc属性
 * <p>
 * Created by wfeng on 2018/6/14.
 */
public class JdbcAttribute {

    //数据库链接
    private String url;

    //用户名
    private String username;

    //密码
    private String password;

    //jdbc驱动
    private String driver;

    //批量读取数量
    private int fetchsize;

    //批量写入数量
    private int batchsize;

    //默认构造
    public JdbcAttribute() {
    }

    //Jdbc属性简单构造
    public JdbcAttribute(String url, String username, String password, String driver) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
    }

    //Jdbc属性源表指定批量读取数量构造
    public JdbcAttribute(String url, String username, String password, String driver, int fetchsize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
        this.fetchsize = fetchsize;
    }

    //Jdbc属性指定批量读取/批量写入数量构造
    public JdbcAttribute(String url, String username, String password, String driver, int fetchsize, int batchsize) {
        this.url = url;
        this.username = username;
        this.password = password;
        this.driver = driver;
        this.fetchsize = fetchsize;
        this.batchsize = batchsize;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public int getFetchsize() {
        return fetchsize;
    }

    public void setFetchsize(int fetchsize) {
        this.fetchsize = fetchsize;
    }

    public int getBatchsize() {
        return batchsize;
    }

    public void setBatchsize(int batchsize) {
        this.batchsize = batchsize;
    }

    @Override
    public String toString() {
        return "JdbcAttribute{" +
                "url='" + url + '\'' +
                ", username='" + username + '\'' +
//                ", password='" + password + '\'' +
                ", driver='" + driver + '\'' +
                ", fetchsize='" + fetchsize + '\'' +
                ", batchsize='" + batchsize + '\'' +
                '}';
    }

    /**
     * Jdbc属性是否为空
     *
     * @return url/username/password/driver 任意一个为空则返回true
     */
    public boolean isEmpty() {
        return StringUtils.isEmpty(url)
                || StringUtils.isEmpty(username)
                || StringUtils.isEmpty(password)
                || StringUtils.isEmpty(driver);
    }
}
