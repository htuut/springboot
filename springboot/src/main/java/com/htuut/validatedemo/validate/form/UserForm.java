package com.htuut.validatedemo.validate.form;

import lombok.Data;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;

@Data
public class UserForm {

    @NotEmpty(message = "姓名不能为空")
    private String name;

    @NotEmpty(message = "密码不能为空")
    private String password;

    @Min(value = 18, message = "年龄不能小于18岁")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    private String email;


}
