package com.htuut.commons.enums;

import lombok.Getter;

@Getter
public enum  ResultEnum {

    PARAM_ERROR(1,"请求参数错误"),

    ;

    private Integer code;

    private String message;

    private ResultEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
