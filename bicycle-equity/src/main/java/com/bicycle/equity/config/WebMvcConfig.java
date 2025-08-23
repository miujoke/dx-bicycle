package com.bicycle.equity.config;

import com.bicycle.common.interceptor.CommonInterceptor;
import com.bicycle.common.interceptor.TraceIdInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

/**
 * @author miujoke
 * @date 2025/3/15 23:22
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Autowired
    private TraceIdInterceptor traceIdInterceptor;


    @Autowired
    private CommonInterceptor commonInterceptor;

    @Override
    protected void addInterceptors(InterceptorRegistry registry) {
        super.addInterceptors(registry);
        registry.addInterceptor(traceIdInterceptor).addPathPatterns("/**");
        registry.addInterceptor(commonInterceptor).addPathPatterns("/**");
    }
}
