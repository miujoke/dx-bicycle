package com.bicycle.common.interceptor;

import com.bicycle.common.service.HtmlService;
import com.bicycle.common.util.IPUtil;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;


/**
 * @author miujoke
 * @date 2025/3/15 23:01
 * 通用拦截器
 */
@Lazy
@Component
public class CommonInterceptor implements HandlerInterceptor {

    private static Logger logger = LoggerFactory.getLogger(CommonInterceptor.class);

    @Autowired
    private HtmlService htmlService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //MDC.put("requestId", idGeneratorService.getVipOrderNumber());
        logger.info("开始访问:{}", request.getRequestURL().toString());
        logger.info("ip地址:{}", IPUtil.getRemoteIP(request));
        request.setAttribute("customTimer", System.currentTimeMillis());
//        if (!"null".equals(baseConfig.getBaseUrl())) {
//            request.setAttribute("ctx", baseConfig.getBaseUrl());
//        } else {
//            request.setAttribute("ctx", htmlService.getBasePath(request));
//        }
//        request.setAttribute("baseAssetsUrl", baseConfig.getBaseAssetsUrl());
//        request.setAttribute("uploadAssetsUrl", baseConfig.getBaseAssetsUploadUrl());
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        long start = (long) request.getAttribute("customTimer");
        long end = System.currentTimeMillis();
        logger.info("结束加载视图:{},总用时:{}ms", request.getRequestURL().toString(), end - start);
        MDC.remove("requestId");
    }
}
