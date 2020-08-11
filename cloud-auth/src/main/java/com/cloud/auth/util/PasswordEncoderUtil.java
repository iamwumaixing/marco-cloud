package com.cloud.auth.util;

import lombok.experimental.UtilityClass;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * 密码工具类-参照nacos源码设计
 *
 * @author wmxing97
 * @date 2020/8/12 1:59
 */
@UtilityClass
public class PasswordEncoderUtil {

    /**
     * 密码加密
     *
     * @param raw
     * @return
     */
    public String encode(String raw) {
        return new BCryptPasswordEncoder().encode(raw);
    }
}
