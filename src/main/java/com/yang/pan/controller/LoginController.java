package com.yang.pan.controller;

import com.yang.pan.domain.Login;
import com.yang.pan.service.LoginService;
import com.yang.pan.utils.ResultUtil;
import com.yang.pan.vo.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@Configuration
public class LoginController {

    @Autowired
    private LoginService loginService;
    //登入校验
    @PostMapping(value = "/login")
    public Result CheckLogin(@Valid Login loginInput, BindingResult bindingResult){
        System.out.println(loginInput.getUname());
        if(bindingResult.hasErrors()){
            return ResultUtil.error(-1,bindingResult.getFieldError().getDefaultMessage());
        }
        Result result=loginService.checkLogin(loginInput);
        return  result;
    }

    @GetMapping(value = "/login/{uname}")
    public Login getLogin(@PathVariable(value = "uname") String uname)throws Exception{
        return loginService.getLogin(uname);
    }
}
