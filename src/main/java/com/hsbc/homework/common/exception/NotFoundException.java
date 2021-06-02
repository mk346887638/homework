package com.hsbc.homework.common.exception;

import com.hsbc.homework.common.enums.HandelStatus;

public class NotFoundException extends GlobalException {
    public NotFoundException(HandelStatus HandelStatus) {
        super(HandelStatus);
    }

    public NotFoundException(String message, HandelStatus HandlerStatus) {
        super(message, HandlerStatus);
    }
}
