package com.htuut.validate.controller;

import com.htuut.commons.enums.ResultEnum;
import com.htuut.commons.exception.UserException;
import com.htuut.commons.utils.ResultVOUtil;
import com.htuut.validate.form.UserForm;
import com.htuut.commons.vo.ResultVO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Map;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    /**
     * 用户注册
     *
     * @param userForm
     * @param bindingResult
     * @return
     */
    @RequestMapping("/register")
    public ResultVO<Map<String, Object>> register(@Valid @RequestBody UserForm userForm, BindingResult bindingResult) {

        //校验请求参数
        if (bindingResult == null || bindingResult.hasErrors()) {
            log.error("【用户注册】参数不正确", userForm);
            throw new UserException(ResultEnum.PARAM_ERROR.getCode(), bindingResult.getFieldError().getDefaultMessage());
        }


        return ResultVOUtil.success();
    }

}
