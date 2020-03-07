package com.liutong.dao;

import com.liutong.entity.User;
import org.beetl.sql.core.annotatoin.Param;
import org.beetl.sql.core.annotatoin.SqlResource;
import org.beetl.sql.core.mapper.BaseMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
@SqlResource("user")
public interface UserDao extends BaseMapper<User> {

    User selectUserById(@Param("id") Integer id);

    List<User> selectUserByNameAndAge(@Param("name") String name,@Param("age") Integer age);

    List<User> selectUserByAge(@Param("age") Integer age,@Param("pagnum") Integer pagnum,@Param("pagsize") Integer pagsize);

    Integer insertUser(User user);
    Integer deleteUserById(@Param("id") Integer id);
}