package com.marco.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * @author wmxing97
 * @date 2020/8/4 11:54 上午
 */
@NoArgsConstructor
public class ValidateCodeException extends RuntimeException {

    private static final long serialVersionUID = -7285211528095468156L;

    public ValidateCodeException(String msg) {
        super(msg);
    }

}
