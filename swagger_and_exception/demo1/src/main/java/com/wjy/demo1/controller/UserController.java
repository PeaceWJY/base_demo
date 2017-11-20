package com.wjy.demo1.controller;



import com.wjy.demo1.service.UserService;
import com.wjy.demo1.vo.BaseResponse;
import com.wjy.demo1.vo.User;
import com.wjy.demo1.vo.UserInfoRequest;
import com.wjy.demo1.vo.UserInfoResponse;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by apple on 2017/7/21.
 */
@RestController
@RequestMapping(value = "user")
public class UserController {

    @Autowired
    private UserService userService;

    private Logger logger = LoggerFactory.getLogger(UserService.class);


    @RequestMapping( value="list",method = RequestMethod.GET)
    @ApiOperation(value = "获取用户列表",notes = "")

    public List<Map<String,Object>> listUsers(){
        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();
        list = userService.find();
        logger.info("执行查询用户信息controller");
        return list;
    }

    @RequestMapping( value="insert",method = RequestMethod.POST)
    @ApiOperation(value = "添加用户",notes = "根据User用户对象进行添加")
    @ApiImplicitParam(name = "UserInfoRequest",value = "对于请求添加用户的详细实体",required = true,dataType = "UserInfoRequest2")
    public BaseResponse insertUsers(@RequestBody UserInfoRequest userInfoRequest){
        User user = new User();
        user.setUname(userInfoRequest.getUname());
        user.setUpass(userInfoRequest.getUpass());
        int code = userService.insertUser(user);
        BaseResponse baseResponse = new BaseResponse();
        if (code>0){
            baseResponse.setCode(1);
            baseResponse.setMsg("insert successful");
        }
        return baseResponse;
    }


    @RequestMapping( value="update",method = RequestMethod.POST)
    @ApiOperation(value = "更新用户" ,notes = "根据请求实体对用户进行更新")
    @ApiImplicitParam(name = "更新用户",value = "根据请求用户id进行更新用户信息",required = true,dataType = "UserInfoRequest2")
    public BaseResponse updateUsers(@RequestBody  UserInfoRequest userInfoRequest){
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("uid",userInfoRequest.getUid());
        map.put("uname",userInfoRequest.getUname());
        map.put("upass",userInfoRequest.getUpass());
        BaseResponse baseResponse = new BaseResponse();
        int code = userService.updateUser(map);
        if (code>0){
            baseResponse.setCode(1);
            baseResponse.setMsg("update successful");
        }
        return baseResponse;
    }
    @RequestMapping( value="delete",method = RequestMethod.POST)
    @ApiOperation(value = "删除用户" ,notes = "根据请求实体对用户进行删除")
    @ApiImplicitParam(name = "删除用户",value = "根据请求用户id进行删除用户信息",required = true,dataType = "UserInfoRequest2")
    public BaseResponse deleteUsers(@RequestBody UserInfoRequest userInfoRequest){
        Map<String,Object> map = new HashMap<String ,Object>();
        map.put("uid",userInfoRequest.getUid());
        BaseResponse baseResponse = new BaseResponse();
        int code = userService.deleteUser(map);
        if (code>0){
            baseResponse.setCode(1);
            baseResponse.setMsg("delete successful");
        }
        return baseResponse;
    }


    @RequestMapping( value="{id}",method = RequestMethod.PUT)
    @ApiOperation(value = "删除用户" ,notes = "根据请求实体对用户进行删除")
    @ApiImplicitParam(name = "删除用户",value = "根据请求用户id进行删除用户信息",required = true,dataType = "UserInfoRequest2")
    public String deleteUsers2(@PathVariable Long id){
       Long id1 = id;
        return "goog";
    }

//在浏览器中请求http://localhost:8080/user/hello 返回结果就是在页面上显示hello字符串或者hello.jsp字符串
    @RequestMapping("hello")
    public String hello(){
        return "hello.jsp";
    }

    @RequestMapping("error")
    public String error() throws Exception{
        throw new Exception();
    }

    @RequestMapping("/error2")
    public String index(@RequestParam String id){
        return "login";
    }

    @RequestMapping("/error_json")
    public String error_json() throws NullPointerException{
        throw new NullPointerException("null point exception");
    }
}
