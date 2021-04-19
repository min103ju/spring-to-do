package com.security.todo.exception.enums;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum UserErrorEnum {
    ERROR_IS_PRESENT("ERROR_IS_PRESENT", "이미 가입한 이메일이 존재합니다.");

    private String code;
    private String desc;

    UserErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
