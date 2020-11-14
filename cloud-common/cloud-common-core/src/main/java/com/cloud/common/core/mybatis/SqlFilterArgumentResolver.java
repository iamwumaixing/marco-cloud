package com.cloud.common.core.mybatis;

import cn.hutool.core.util.StrUtil;
import com.baomidou.mybatisplus.core.metadata.OrderItem;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.MethodParameter;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * 解决Mybatis Plus Order By SQL注入问题
 *
 * @author wmxing97
 * @date 2020/8/4 10:58 上午
 */
@Slf4j
public class SqlFilterArgumentResolver implements HandlerMethodArgumentResolver {

    private final static String[] KEYWORDS = {"master", "truncate", "insert", "select", "delete", "update", "declare",
            "alter", "drop", "sleep"};


    /**
     * 判断 Controller 是否包含 page 参数
     *
     * @param methodParameter 参数
     * @return 是否过滤
     */
    @Override
    public boolean supportsParameter(MethodParameter methodParameter) {
        return methodParameter.getParameterType().equals(Page.class);
    }

    /**
     * @param methodParameter       入参集合
     * @param modelAndViewContainer model 和 view
     * @param nativeWebRequest      web
     * @param webDataBinderFactory  入参解析工厂
     * @return 检查后新对page对象
     * @throws Exception e
     *                   page 只支持查询 GET，如果需要解析POST获取请求报文体处理
     */
    @Override
    public Object resolveArgument(MethodParameter methodParameter, ModelAndViewContainer modelAndViewContainer,
                                  NativeWebRequest nativeWebRequest, WebDataBinderFactory webDataBinderFactory) throws Exception {
        HttpServletRequest request = nativeWebRequest.getNativeRequest(HttpServletRequest.class);

        String[] ascs = request.getParameterValues("ascs");
        String[] descs = request.getParameterValues("descs");
        String current = request.getParameter("current");
        String size = request.getParameter("size");

        Page page = new Page();
        if (StrUtil.isNotBlank(current)) {
            page.setCurrent(Long.parseLong(current));
        }
        if (StrUtil.isNotBlank(size)) {
            page.setSize(Long.parseLong(size));
        }

        List<OrderItem> orderItemList = new ArrayList<>();
        Optional.ofNullable(ascs).ifPresent(s -> orderItemList.addAll(
                Arrays.stream(s).filter(sqlInjectPredicate()).map(OrderItem::asc).collect(Collectors.toList())));
        Optional.ofNullable(descs).ifPresent(s -> orderItemList.addAll(
                Arrays.stream(s).filter(sqlInjectPredicate()).map(OrderItem::desc).collect(Collectors.toList())));
        page.addOrder(orderItemList);

        return page;
    }

    /**
     * 判断用户输入里有没有不安全的关键字
     *
     * @return Predicate
     */
    private Predicate<String> sqlInjectPredicate() {
        return sql -> {
            for (String keyword : KEYWORDS) {
                if (StrUtil.containsIgnoreCase(sql, keyword)) {
                    return false;
                }
            }
            return true;
        };
    }
}
