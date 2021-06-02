package com.hsbc.homework.vo;
import com.hsbc.homework.common.enums.ErrorStatus;
import com.hsbc.homework.common.enums.HandelStatus;
import org.springframework.http.HttpStatus;

public class RestErrorVo {
    private int code;
    private String message;
    private Object errors;

    public RestErrorVo(int code, String message) {
        this.message = message;
        this.code = code;
    }

    public RestErrorVo(int code, String message, Object errors) {
        this.code = code;
        this.message = message;
        this.errors = errors;
    }

    public RestErrorVo(HttpStatus httpStatus) {
        this.code = httpStatus.value();
        this.message = httpStatus.getReasonPhrase();
    }

    public RestErrorVo(ErrorStatus errorStatus) {
        this.code = errorStatus.getCode();
        this.message = errorStatus.getmessage();
    }

    public RestErrorVo(ErrorStatus errorStatus, Object errors) {
        this.code = errorStatus.getCode();
        this.message = errorStatus.getmessage();
        this.errors = errors;
    }

    public RestErrorVo(HandelStatus handlerStatus) {
        this.code = handlerStatus.getCode();
        this.message = handlerStatus.getmessage();
    }

    public int getCode() {
        return this.code;
    }

    public String getMessage() {
        return this.message;
    }

    public Object getErrors() {
        return this.errors;
    }

    public void setCode(final int code) {
        this.code = code;
    }

    public void setMessage(final String message) {
        this.message = message;
    }

    public void setErrors(final Object errors) {
        this.errors = errors;
    }

    public boolean equals(final Object o) {
        if (o == this) {
            return true;
        } else if (!(o instanceof RestErrorVo)) {
            return false;
        } else {
            RestErrorVo other = (RestErrorVo)o;
            if (!other.canEqual(this)) {
                return false;
            } else if (this.getCode() != other.getCode()) {
                return false;
            } else {
                Object this$message = this.getMessage();
                Object other$message = other.getMessage();
                if (this$message == null) {
                    if (other$message != null) {
                        return false;
                    }
                } else if (!this$message.equals(other$message)) {
                    return false;
                }

                Object this$errors = this.getErrors();
                Object other$errors = other.getErrors();
                if (this$errors == null) {
                    if (other$errors != null) {
                        return false;
                    }
                } else if (!this$errors.equals(other$errors)) {
                    return false;
                }

                return true;
            }
        }
    }

    protected boolean canEqual(final Object other) {
        return other instanceof RestErrorVo;
    }



    public String toString() {
        return "RestErrorVo(code=" + this.getCode() + ", message=" + this.getMessage() + ", errors=" + this.getErrors() + ")";
    }
}
