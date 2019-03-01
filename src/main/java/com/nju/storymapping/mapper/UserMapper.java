package com.nju.storymapping.mapper;/*
 * @program:com.nju.storymapping.mapper
 * @description:用户信息处理类
 * @author:shiliang
 * @create:2019-01-12 13:42
 * */

import com.nju.storymapping.entity.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {

    @Insert("INSERT INTO user(username,password,salt) VALUES(#{username}, #{password}, #{salt})")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void addUser(User user);

    @Select("SELECT * FROM user WHERE id = #{id}")
    User getUserById(int id);

    @Select("SELECT * FROM user WHERE username = #{username}")
    User getUserByName(String username);



}
