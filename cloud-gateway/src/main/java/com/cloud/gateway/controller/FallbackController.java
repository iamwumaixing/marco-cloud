package com.cloud.gateway.controller;

import com.cloud.common.core.util.Result;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * fallback response controller
 *
 * @author marco
 */
@RestController
public class FallbackController {

    @GetMapping("/fallbackResponse")
    public Result fallbackResponse() {
        return Result.failed(null, "Service unavailable.");
    }
}
