package com.htuut.commons.vo;

import lombok.Data;

@Data
public class ResultVO<T> {

    private String code;

    private String message;

    private T data;

}
