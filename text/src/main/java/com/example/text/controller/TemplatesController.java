package com.example.text.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by apple on 2017/7/22.
 */
@Controller
@RequestMapping("test")
public class TemplatesController {
    //在属性中不能完全一样 必须有一个不同 method或者value不同
    @RequestMapping(value="/test1" ,method = RequestMethod.GET)
    public String index(Model map){;
        map.addAttribute("name","dear");
        return "test";
    }
    @RequestMapping(value="/test1" ,method = RequestMethod.POST)
    public String index2(Model map){;
        map.addAttribute("name","dear");
        return "test1";
    }
}
