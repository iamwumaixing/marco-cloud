package com.cloud.userservice.exception;

import com.cloud.common.core.exception.ErrorType;
import lombok.Getter;

/**
 * @author marco
 * @date 2020/11/15 12:06 上午
 */
@Getter
public enum UserSvcErrorType implements ErrorType {

    USER_NOT_FOUND("10001", "用户未找到"),
    ROLE_NOT_FOUND("10002", "角色未找到");

    /**
     * 错误码
     */
    private String code;

    /**
     * 错误信息
     */
    private String msg;

    UserSvcErrorType(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
