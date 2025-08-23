package com.bicycle.common.interceptor;

import com.bicycle.common.util.SnowflakeIdGenerator;
import org.slf4j.MDC;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * 日志id
 * @author miujoke
 * @date 2025/8/23 18:39
 */

@Component
public class TraceIdInterceptor implements HandlerInterceptor {

    private final SnowflakeIdGenerator idGenerator = new SnowflakeIdGenerator(1, 1);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        String traceId = String.valueOf(idGenerator.nextId());
        MDC.put("traceId", traceId);
        response.setHeader("X-Trace-Id", traceId); // 返回给客户端
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        MDC.remove("traceId");
    }
}
