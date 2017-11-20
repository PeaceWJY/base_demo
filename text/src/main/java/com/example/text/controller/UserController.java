package com.example.text.controller;

import com.example.text.vo.User;
import com.sun.tools.jconsole.JConsoleContext;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by apple on 2017/7/22.
 */
@RestController
@RequestMapping("user")
public class UserController {
    //创建线程安全的Map
     Map<String,User> users = new HashMap<String,User>();
     @RequestMapping("test")
public String test (){
    return "hello";
}

}
