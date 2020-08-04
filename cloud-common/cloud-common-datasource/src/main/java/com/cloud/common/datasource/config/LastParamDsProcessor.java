package com.cloud.common.datasource.config;

import com.baomidou.dynamic.datasource.processor.DsProcessor;
import org.aopalliance.intercept.MethodInvocation;

/**
 * 动态参数解析数据源
 * https://github.com/baomidou/dynamic-datasource-spring-boot-starter/wiki/Dynamic-Analysis-DataSource
 * 说明：带有 @DS(#last) 执行当前执行器，执行器会将最后一个参数作为数据源名称，具体看 doDetermineDatasource 方法
 *
 * @author wmxing97
 * @date 2020/8/4 3:23 下午
 */
public class LastParamDsProcessor extends DsProcessor {

    private static final String LAST_PREFIX = "#last";

    /**
     * 抽象匹配条件 匹配才走当前执行器 否则走下一级执行器
     *
     * @param key DS注解里的内容
     * @return 是否匹配
     */
    @Override
    public boolean matches(String key) {
        return key.startsWith(LAST_PREFIX);
    }

    /**
     * 抽象最终决定数据源
     *
     * @param methodInvocation 方法执行信息
     * @param key              DS注解里的内容
     * @return 数据源名称
     */
    @Override
    public String doDetermineDatasource(MethodInvocation methodInvocation, String key) {
        Object[] arguments = methodInvocation.getArguments();
        return String.valueOf(arguments[arguments.length - 1]);
    }
}
