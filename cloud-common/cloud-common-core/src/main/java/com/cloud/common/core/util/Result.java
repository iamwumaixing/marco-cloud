package com.cloud.common.core.util;

import com.cloud.common.core.constant.CommonConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 响应信息主体
 *
 * @author wmxing97
 * @date 2020/8/4 11:33 上午
 */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;

    private String msg;

    private T data;

    public static <T> Result<T> ok() {
        return restResult(null, CommonConstants.SUCCESS, null);
    }

    public static <T> Result<T> ok(T data) {
        return restResult(data, CommonConstants.SUCCESS, null);
    }

    public static <T> Result<T> ok(T data, String msg) {
        return restResult(data, CommonConstants.SUCCESS, msg);
    }

    public static <T> Result<T> failed() {
        return restResult(null, CommonConstants.FAIL, null);
    }

    public static <T> Result<T> failed(T data) {
        return restResult(data, CommonConstants.FAIL, null);
    }

    public static <T> Result<T> failed(T data, String msg) {
        return restResult(data, CommonConstants.FAIL, msg);
    }

    public static <T> Result<T> forbidden(T data) {
        return restResult(data, CommonConstants.FORBIDDEN, null);
    }

    public static <T> Result<T> unauthorized(T data) {
        return restResult(data, CommonConstants.UNAUTHORIZED, null);
    }

    private static <T> Result<T> restResult(T data, int code, String msg) {
        Result<T> apiResult = new Result<>();
        apiResult.setCode(code);
        apiResult.setData(data);
        apiResult.setMsg(msg);

        return apiResult;
    }

}
