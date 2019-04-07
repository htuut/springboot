package com.htuut.validate.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    private String code;

    private String message;

    private T data;

}
