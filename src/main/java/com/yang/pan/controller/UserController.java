package com.yang.pan.controller;

import com.yang.pan.aspect.HttpAspect;
import com.yang.pan.domain.User;
import com.yang.pan.domain.UserRepository;
import com.yang.pan.service.UserService;
import com.yang.pan.utils.ResultUtil;
import com.yang.pan.vo.Result;
import com.yang.pan.vo.UserInput;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@Configuration
public class UserController {
    private final static Logger logger = LoggerFactory.getLogger(HttpAspect.class);
    @Autowired
    private UserService userService;
    @Autowired
    private UserRepository userRepository;

    /**
     * 新增用户信息
     * @param userInput
     * @param bindingResult
     * @return
     */
    @PostMapping(value = "/user")
    public Result addLogin(@Valid UserInput userInput, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            System.out.println(bindingResult.getFieldError().getField());
            return ResultUtil.error(1,bindingResult.getFieldError().getDefaultMessage());

        }
        userService.userInputCheck(userInput);
        User user = userRepository.findByUname(userInput.getUname());
        return ResultUtil.success(user);
    }

    /**
     * 注销用户信息
     * 注意是所有用户信息
     * @param uid
     */
    @DeleteMapping(value = "/user/{uid}")
    public void deleteUser(@PathVariable("uid") Integer uid){
        userService.deleteUser(uid);
    }

    /**
     * 修改用户信息
     * 注意用户名不可修改
     * @param user
     * @return
     */
    @PutMapping(value = "/user/{uid}")
    public Result updateUser(User user){

       return  ResultUtil.success(userService.updateUser(user));
    }
    @GetMapping(value = "/user/{uid}")
    public Result getUser(@PathVariable("uid") Integer uid){
        return ResultUtil.success(userService.getUser(uid));
    }

}
