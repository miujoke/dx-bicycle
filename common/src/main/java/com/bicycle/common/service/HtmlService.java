package com.bicycle.common.service;

import jakarta.servlet.http.HttpServletRequest;

/**
 * @author miujoke
 * @date 2025/3/15 23:07
 */
public interface HtmlService {

    /**
     * 获取项目基路径
     *
     * @param request
     * @return
     */
    public String getBasePath(HttpServletRequest request);
}
