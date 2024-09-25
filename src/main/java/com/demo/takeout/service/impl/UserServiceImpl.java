package com.demo.takeout.service.impl;


import com.demo.takeout.exception.BizException;
import com.demo.takeout.mapper.UserMapper;
import com.demo.takeout.pojo.dto.LoginDto;
import com.demo.takeout.pojo.entity.User;
import com.demo.takeout.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(LoginDto loginDto) {
        User user =  userMapper.getByUsername(loginDto.getUsername());
        if(user == null){
            throw new BizException("账号不存在");
        }
        return user;
    }
}
