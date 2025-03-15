package com.bicycle.common.exception;

/**
 * @author miujoke
 * @date 2025/3/14 0:34
 *
 * 统一对ModelAndView异常的管理
 */
public class ModelAndViewException extends Exception {

    public ModelAndViewException() {
    }

    public ModelAndViewException(String message) {
        super(message);
    }

    public ModelAndViewException(String message, Throwable cause) {
        super(message, cause);
    }

    public ModelAndViewException(Throwable cause) {
        super(cause);
    }

    public ModelAndViewException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
