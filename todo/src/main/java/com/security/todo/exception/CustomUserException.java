package com.security.todo.exception;

import com.security.todo.exception.enums.ErrorEnum;

public class CustomUserException extends Exception{

    private ErrorEnum errorEnum;

    public CustomUserException(String message) {
        super(message);
    }

    public CustomUserException(ErrorEnum errorEnum) {
        super(errorEnum.getDesc());
        this.errorEnum = errorEnum;
    }
}
