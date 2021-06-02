package com.hsbc.homework.common.exception;

import com.hsbc.homework.common.enums.HandelStatus;

public class GlobalException extends Exception {
    private int code;

    public GlobalException(HandelStatus HandlerStatus) {
        super(HandlerStatus.getmessage());
        this.code = HandlerStatus.getCode();
    }

    public GlobalException(String message) {
        super(message);
    }

    public GlobalException(String message, HandelStatus HandlerStatus) {
        super(message);
        this.code = HandlerStatus.getCode();
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getCode() {
        return this.code;
    }
}
