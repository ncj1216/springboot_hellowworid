package com.offcn.controller;


import org.codehaus.groovy.util.StringUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpSession;
import java.util.Map;


@Controller
public class LoginController {


    @PostMapping(value ="/user/login")
    public String login(@RequestParam("username") String username, @RequestParam("password")
                                           String password, Map<String,Object> map, HttpSession session){

        if (!StringUtils.isEmpty(username) && "123456".equals(password)){
            //登录成功的
            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        }else {
            //登陆失败
            map.put("msg","账号或者密码错误");
            return "login";
        }


    }
}
