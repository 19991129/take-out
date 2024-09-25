package com.demo.takeout.service;

import com.demo.takeout.pojo.dto.LoginDto;
import com.demo.takeout.pojo.entity.User;

public interface UserService {
    User login(LoginDto loginDto);
}
