package com.security.todo.exception;

import com.security.todo.exception.enums.ErrorEnum;

public class CustomException extends Exception{

    private ErrorEnum errorEnum;

    public CustomException(String message) {
        super(message);
    }

    public CustomException(ErrorEnum errorEnum) {
        super(errorEnum.getDesc());
        this.errorEnum = errorEnum;
    }
}
