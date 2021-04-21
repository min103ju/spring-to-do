package com.security.todo.exception.enums;

import lombok.Getter;

@Getter
public enum ErrorEnum {
    ERROR_USER_ALREADY_PRESENT("10001", "이미 가입한 이메일이 존재합니다."),
    ERROR_WRONG_PATH("10002", "잘못된 URL 경로입니다."),
    ERROR_INTERNAL_SERVER_ERROR("10002", "서버 내부 에러입니다.");

    private String code;
    private String desc;

    ErrorEnum(String code, String desc) {
        this.code = code;
        this.desc = desc;
    }

}
