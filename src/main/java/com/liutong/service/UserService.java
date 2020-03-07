package com.liutong.service;

import com.liutong.dao.UserDao;
import com.liutong.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("userService")
public class UserService {
    @Autowired
    UserDao userDao;
    public User selectUserById(int i){
        return userDao.selectUserById(i);
    }

    public List<User> selectUserByNameAndAge(String name,Integer age){
        return userDao.selectUserByNameAndAge(name,age);
    }

    public List<User> selectUserByAge(Integer age,Integer num,Integer size){
        return userDao.selectUserByAge(age,num,size);
    }

    public Integer insertUser(User user) {
       return userDao.insertUser(user);
    }
    public Integer deleteUserById(Integer id){
        return userDao.deleteUserById(id);
    }
}
