package com.cloud.common.core.exception;

/**
 * @author marco
 * @date 2020/11/14 11:51 下午
 */
public interface ErrorType {
    /**
     * get code
     *
     * @return
     */
    String getCode();

    /**
     * get message
     *
     * @return
     */
    String getMsg();

}
