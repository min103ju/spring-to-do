package com.security.todo.exception;

import com.security.todo.exception.enums.UserErrorEnum;

public class CustomUserException extends Exception{

    private UserErrorEnum userErrorEnum;

    public CustomUserException(String message) {
        super(message);
    }

    public CustomUserException(UserErrorEnum userErrorEnum) {
        super(userErrorEnum.getDesc());
        this.userErrorEnum = userErrorEnum;
    }
}
