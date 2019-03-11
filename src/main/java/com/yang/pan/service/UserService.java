package com.yang.pan.service;

import com.yang.pan.domain.*;
import com.yang.pan.vo.PanException;
import com.yang.pan.vo.ResultEnum;
import com.yang.pan.vo.UserInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;

@Service
public class UserService {
    @Autowired
    private LoginRepository loginRepository;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private DirectoryRepository directoryRepository;
    @Autowired
    private FileRepository fileRepository;

    /**
     * 用户注册信息校验
     * @param userInput
     */
    public void userInputCheck(UserInput userInput){
        User user = userRepository.findByUname(userInput.getUname());
        if(user!=null){
            throw new PanException(ResultEnum.UNAME_HASEXISTENTED);
        }
        else if(!userInput.getPassword().equals(userInput.getAgainpassword())){
            throw new PanException(ResultEnum.PASSWORD_NOTMATCH);
        }else{
            addUserAndLogin(userInput);
        }
    }

    /**
     * 添加用户信息和登入信息
     * @param userInput
     */
    @Transactional
    public void addUserAndLogin(UserInput userInput){
        User user = new User();
        user.setUname(userInput.getUname());
        user.setSex(userInput.getSex());
        user.setPhone(userInput.getPhone());
        user.setEmail(userInput.getEmail());
        user.setIntroduction(userInput.getIntroduction());
        user.setPicture("F:a.png");
        user.setModifieddate(new Date());
        user.setCreatedate(new Date());
        userRepository.save(user);

        Login login = new Login();
        login.setUname(userInput.getUname());
        login.setPassword(userInput.getPassword());
        loginRepository.save(login);

        Directory directory = new Directory();
        directory.setCreatedate(new Date());
        directory.setModifieddate(new Date());
        directory.setUname(user.getUname());
        directory.setDirname(user.getUname());
        directory.setUpdirid(0);
        directoryRepository.save(directory);

    }

    /**
     * 删除所有用户信息
     * @param uid
     */
    public void deleteUser(Integer uid){
        User user = userRepository.findOne(uid);
        fileRepository.deleteAllByUname(user.getUname());
        directoryRepository.deleteAllByUname(user.getUname());
        loginRepository.deleteAllByUname(user.getUname());
        userRepository.delete(uid);
    }

    /**
     * 跟新用户信息
     * @param user
     * @return
     */
    public User updateUser(User user){
        User user1 = userRepository.findByUname(user.getUname());
        if(user1==null){
            throw new PanException(ResultEnum.UNAME_UNCHANGE);
        }
        if(user.getCreatedate()==null){
        user.setCreatedate(user1.getCreatedate());
        }
        if(user.getPicture()==null){
            user.setPicture(user1.getPicture());
        }
        if(user.getModifieddate()==null){
            user.setModifieddate(new Date());
        }
        if(user.getIntroduction()==null){
            user.setIntroduction(user1.getIntroduction());
        }



        return userRepository.save(user);
    }

    public User getUser(Integer uid){
        User user = userRepository.findOne(uid);
        if(user == null){
            throw new PanException(ResultEnum.UNAME_UNCHANGE);
        }

        return  user;
    }
}
