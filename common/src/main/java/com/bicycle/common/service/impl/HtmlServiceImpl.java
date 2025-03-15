package com.bicycle.common.service.impl;

import com.bicycle.common.service.HtmlService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

/**
 * @author miujoke
 * @date 2025/3/15 23:08
 * html网页处理相关的通用方法
 */
@Component("htmlService")
public class HtmlServiceImpl implements HtmlService {

    @Override
    public String getBasePath(HttpServletRequest request) {
        String path = request.getContextPath();
        String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + path;
        return basePath;
    }
}
