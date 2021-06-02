package com.hsbc.homework.common.exception;

import com.hsbc.homework.common.enums.HandelStatus;

public class DataException extends GlobalException {
    public DataException(HandelStatus HandelStatus) {
        super(HandelStatus);
    }

    public DataException(String message, HandelStatus HandelStatus) {
        super(message, HandelStatus);
    }
}
