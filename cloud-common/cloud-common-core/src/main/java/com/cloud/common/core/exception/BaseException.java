package com.cloud.common.core.exception;

import lombok.Getter;


/**
 * 基础异常类
 *
 * @author marco
 * @date 2020/11/14 11:42 下午
 */
@Getter
public class BaseException extends RuntimeException {

    /**
     * 异常类型
     */
    private final ErrorType errorType;

    /**
     * Default: system exception
     */
    public BaseException() {
        this.errorType = SystemErrorType.SYSTEM_ERROR;
    }

    public BaseException(ErrorType errorType) {
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message) {
        super(message);
        this.errorType = errorType;
    }

    public BaseException(ErrorType errorType, String message, Throwable cause) {
        super(message, cause);
        this.errorType = errorType;
    }


}
