package com.offcn.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Controller
public class hellowordController {



    @RequestMapping("/hello")
    @ResponseBody
    public String hello(){

        return "卢本伟牛逼";
    }

    @RequestMapping("/heel")
    public String success(Map<String,Object> map){

        map.put("hello","卢本伟吃大便");
        return "success";
    }



}
