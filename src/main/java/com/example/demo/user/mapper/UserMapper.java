package com.example.demo.user.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.user.model.User;

@Mapper
public interface UserMapper {

    @Select("SELECT * FROM tb_user")
    List<User> findAll();

    User findByUserId(@Param("id") int id);
    
    String nameCheck(@Param("name") String name);
    
    @Insert("INSERT INTO tb_user(id,name, part) VALUES(#{id},#{name}, #{part})")
    @SelectKey(statement="select SEQ_TB_USER.nextval FROM DUAL", keyProperty="id", before=true, resultType=int.class)
    int save(final User user);
    
    int update(final User user);
    
    
    @Delete("DELETE  FROM tb_user where id = #{id}")
    int delete(@Param("id") int id);
}