package com.marco.common.core.exception;

import lombok.NoArgsConstructor;

/**
 * 403 授权拒绝
 *
 * @author wmxing97
 * @date 2020/8/4 11:51 上午
 */
@NoArgsConstructor
public class DeniedException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public DeniedException(String message) {
        super(message);
    }

    public DeniedException(Throwable cause) {
        super(cause);
    }

    public DeniedException(String message, Throwable cause) {
        super(message, cause);
    }

    public DeniedException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
