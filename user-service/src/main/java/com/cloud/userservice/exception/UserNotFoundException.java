package com.cloud.userservice.exception;

import com.cloud.common.core.exception.BaseException;

/**
 * @author marco
 * @date 2020/11/14 11:41 下午
 */
public class UserNotFoundException extends BaseException {

    public UserNotFoundException() {
        super(UserSvcErrorType.USER_NOT_FOUND);
    }

    public UserNotFoundException(String message) {
        super(UserSvcErrorType.USER_NOT_FOUND, message);
    }

}
