package com.htuut.validatedemo.commons.utils;

import com.htuut.validatedemo.commons.vo.ResultVO;

public class ResultVOUtil {

    public static ResultVO success(Object obj) {
        ResultVO resultVO = new ResultVO();
        resultVO.setMessage("成功");
        resultVO.setCode("1");
        resultVO.setData(obj);

        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }


    public static ResultVO error(String code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }

}
