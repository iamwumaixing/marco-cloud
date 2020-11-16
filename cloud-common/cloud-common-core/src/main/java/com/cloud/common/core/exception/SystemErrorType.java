package com.cloud.common.core.exception;

import lombok.Getter;


/**
 * @author marco
 * @date 2020/11/14 11:46 下午
 */
@Getter
public enum SystemErrorType implements ErrorType {

    SYSTEM_ERROR("-1", "系统异常"),
    SYSTEM_BUSY("-100", "系统忙，请稍后再试");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    SystemErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
