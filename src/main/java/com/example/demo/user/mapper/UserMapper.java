package com.example.demo.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import com.example.demo.user.model.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM user")
    List<User> findAll();

    @Select("SELECT * FROM user WHERE userIdx = #{userIdx}")
    User findByUserIdx(@Param("userIdx") int userIdx);
    
    @Insert("INSERT INTO user(name, part) VALUES(#{name}, #{part}")
    @Options(useGeneratedKeys = true, keyProperty = "userIdx")
    int save(@Param("user") final User user);
}