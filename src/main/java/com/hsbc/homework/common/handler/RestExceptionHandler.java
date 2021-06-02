package com.hsbc.homework.common.handler;

import com.hsbc.homework.common.enums.ErrorStatus;
import com.hsbc.homework.common.enums.HandelStatus;
import com.hsbc.homework.common.exception.DataException;
import com.hsbc.homework.common.exception.NotFoundException;
import com.hsbc.homework.vo.RestErrorVo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.support.DefaultMessageSourceResolvable;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.stream.Collectors;

@RestControllerAdvice
public class RestExceptionHandler {
    private static final Logger log = LoggerFactory.getLogger(RestExceptionHandler.class);

    public RestExceptionHandler() {
    }

    @ExceptionHandler({NotFoundException.class})
    @ResponseBody
    @ResponseStatus(
            code = HttpStatus.NOT_FOUND
    )
    public RestErrorVo handleNotFoundException(NotFoundException e) {
        log.error(e.getMessage(), e);
        return new RestErrorVo(e.getCode(), e.getMessage());
    }

    @ExceptionHandler
    @ResponseBody
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public RestErrorVo handleGlobalException(Exception e) {
        log.error(e.getMessage(), e);
        return new RestErrorVo(HandelStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler({MethodArgumentNotValidException.class})
    @ResponseBody
    @ResponseStatus(
            code = HttpStatus.INTERNAL_SERVER_ERROR
    )
    public RestErrorVo handleValidateException(MethodArgumentNotValidException e) {
        List<String> errorList = (List)e.getBindingResult().getAllErrors().stream().map(DefaultMessageSourceResolvable::getDefaultMessage).collect(Collectors.toList());
        return new RestErrorVo(ErrorStatus.DATA_FORMAT_ERROR, errorList);
    }

    @ExceptionHandler({DataException.class})
    @ResponseBody
    @ResponseStatus(
            code = HttpStatus.INTERNAL_SERVER_ERROR
    )
    public RestErrorVo handleDataException(DataException e) {
        log.error(e.getMessage(), e);
        return new RestErrorVo(e.getCode(), e.getMessage());
    }
}
