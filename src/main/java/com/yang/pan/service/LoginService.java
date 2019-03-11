package com.yang.pan.service;

import com.yang.pan.domain.Login;
import com.yang.pan.domain.LoginRepository;
import com.yang.pan.utils.ResultUtil;
import com.yang.pan.vo.PanException;
import com.yang.pan.vo.Result;
import com.yang.pan.vo.ResultEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoginService {
    @Autowired
    private LoginRepository loginRepository;

    /**
     * 添加一条注册信息
     * @param login
     */
    public Login addLogin(Login login){
        return loginRepository.save(login);
    }

    /**
     * 通过用户名查找
     * @param uname
     * @return
     */
    public Login getLogin(String uname)throws Exception{
        Login login=loginRepository.findByUname(uname);
        if(login==null)
            throw new PanException(ResultEnum.UNAME_NOTEXISTENT);
        return login;
    }

    /**
     * 登入校验
     * @param loginInput
     * @return
     */
    public Result checkLogin(Login loginInput){
        Login login= loginRepository.findByUname(loginInput.getUname());

        if(login==null){
            return ResultUtil.error(ResultEnum.UNAME_NOTEXISTENT);

        }else if(!login.getPassword().equals(loginInput.getPassword())){

            return ResultUtil.error(ResultEnum.PASSWORD_ERROR);
        }else {
            return ResultUtil.success(login);
        }

    }

}
