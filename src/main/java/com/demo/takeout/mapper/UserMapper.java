package com.demo.takeout.mapper;

import com.demo.takeout.pojo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface UserMapper{
    @Select("select * from employee where username = #{username}")
    User getByUsername(String username);
}
