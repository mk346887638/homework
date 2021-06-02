package com.hsbc.homework.common.enums;

public enum ErrorStatus {
    USER_NOT_FOUND(40401, "? 用户不存在"),
    DEPT_NOT_FOUND(40402, "? 部门不存在"),
    ATTACHMENT_NOT_FOUND(40403, "? 附件不存在"),
    ROLE_NOT_FOUND(40404, "? 角色不存在"),
    DATA_FORMAT_ERROR(50000, "数据格式有误"),
    PARAMETER_ERROR(51000, "参数错误"),
    DATABASE_ERROR(52000, "数据库异常");

    private int code;
    private String message;

    public int getCode() {
        return this.code;
    }

    public String getmessage() {
        return this.message;
    }

    private ErrorStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
