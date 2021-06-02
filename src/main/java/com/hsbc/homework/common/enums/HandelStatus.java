package com.hsbc.homework.common.enums;

public enum HandelStatus {
    UNAUTHORIZED(401, "未授权"),
    FORBIDDEN(403, "访问限制"),
    NOT_FOUND(404, "未找到"),
    INTERNAL_SERVER_ERROR(500, "后台处理错误"),
    DATA_UNAUTHORIZED(40101, "数据未授权");

    private int code;
    private String message;

    public int getCode() {
        return this.code;
    }

    public String getmessage() {
        return this.message;
    }

    private HandelStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}

