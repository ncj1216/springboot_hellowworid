package com.offcn.springboot.component;


import org.codehaus.groovy.util.StringUtil;
import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;


/*
* 可以连接上携带的区域信息
* */
public class MyLocaleReolver implements LocaleResolver {
    @Override
    public Locale resolveLocale(HttpServletRequest request) {

        String l=request.getParameter("l");
        Locale locale=Locale.getDefault();//有参数用有参数的语言，没用的话用默认的
        if (!StringUtils.isEmpty(l)){
            String[] split = l.split("_");
          locale= new Locale(split[0], split[1]);//语言国家代码


        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }
}
