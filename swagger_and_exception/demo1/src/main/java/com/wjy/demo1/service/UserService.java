package com.wjy.demo1.service;

import com.wjy.demo1.dao.UserDao;
import com.wjy.demo1.vo.User;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;


/**
 * Created by apple on 2017/7/21.
 */
@Service
public class UserService {
    @Autowired
    UserDao userDao;

    private org.slf4j.Logger logger = LoggerFactory.getLogger(UserService.class);

    public List<Map<String,Object>> find(){
        logger.info("执行service中的查询用户列表方法");
        return userDao.find();
    }
    public int insertUser(User user){
        logger.info("执行service中的添加用户方法");
        return userDao.insertUser(user);
    }
    public int deleteUser(Map<String,Object> map){
        logger.info("执行service中的删除用户方法");
        return userDao.deleteUser(map);
    }
    public int updateUser(Map<String,Object> map){
        logger.info("执行service中的更新用户方法");
        return userDao.updateUser(map);
    }
}
