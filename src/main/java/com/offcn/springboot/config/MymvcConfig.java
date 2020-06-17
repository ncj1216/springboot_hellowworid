package com.offcn.springboot.config;


import com.offcn.springboot.component.LoginHandlerInterceptor;
import com.offcn.springboot.component.MyLocaleReolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;


/*这个注解标记这个是一个配置类*/
@Configuration
public class MymvcConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        //l浏览器发送niu这个请求会跳转到success页面
        registry.addViewController("/niu").setViewName("success");


        //super.addViewControllers(registry);
    }

    //第二种方式
    @Bean    //将组件注册到容器中
    public WebMvcConfigurerAdapter show(){

        WebMvcConfigurerAdapter adapter = new WebMvcConfigurerAdapter() {

            @Override
            public void addViewControllers(ViewControllerRegistry registry) {

                registry.addViewController("/login").setViewName("login");
                registry.addViewController("/login.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");

            }


            //注册拦截器的
            @Override
            public void addInterceptors(InterceptorRegistry registry) {

                registry.addInterceptor(new LoginHandlerInterceptor()).addPathPatterns("/**")
                        .excludePathPatterns("/login.html","/","/login","/user/login");


            }
        };

        return adapter;

    }

    @Bean
    public LocaleResolver localeResolver(){



        return new MyLocaleReolver();
    }


}
