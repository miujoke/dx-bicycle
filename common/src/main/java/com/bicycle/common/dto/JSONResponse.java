package com.bicycle.common.dto;

/**
 * @author miujoke
 * @date 2025/3/15 23:17
 */
public class JSONResponse {
    /**
     * 0:没有错误一些正常  1001:服务器错    误 1002: 业务逻辑错误
     */
    private int errorCode;
    /**
     * 成功时返回的对象
     */
    private Object returnObject = null;
    /**
     * 提示信息
     */
    private String message;

    public int getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }

    public Object getReturnObject() {
        return returnObject;
    }

    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
