package com.xxl.job.admin.core.exception;

/**
 * 数据立方服务异常
 * <p>
 * Created by wfeng on 2018/7/4.
 */
public class CubeServiceException extends Exception {

    public CubeServiceException() {
        super();
    }

    public CubeServiceException(String msg) {
        super(msg);
    }

    public CubeServiceException(Throwable cause) {
        super(cause);
    }

    public CubeServiceException(String msg, Throwable cause) {
        super(msg, cause);
    }
}
