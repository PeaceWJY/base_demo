package com.wjy.demo1.dao;

import com.wjy.demo1.mapper.UserMapper;
import com.wjy.demo1.vo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * Created by apple on 2017/7/21.
 */
@Repository
public class UserDao {
    @Autowired
    UserMapper userMapper;
    public List<Map<String,Object>> find(){

        return userMapper.listUsers();
    }
     public int insertUser(User user){

        return userMapper.insertUser(user);
     }
    public int deleteUser(Map<String,Object> map){

         return userMapper.deleteUser(map);
    }
    public int updateUser(Map<String,Object> map){

        return userMapper.updateUser(map);
    }
}
