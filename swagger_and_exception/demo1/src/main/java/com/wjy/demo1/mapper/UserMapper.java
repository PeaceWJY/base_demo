package com.wjy.demo1.mapper;

import com.wjy.demo1.vo.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by apple on 2017/7/21.
 */
@Mapper
public interface UserMapper {
    public List<Map<String,Object>> listUsers();
    public int insertUser(User user);
    public int deleteUser(Map<String,Object> map);
    public int updateUser(Map<String,Object> map);
}
