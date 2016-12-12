package com.xing.springboot_02;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by 汪东兴 on 2016-12-4.
 */
@Configuration
public class WebMvcConfig extends WebMvcConfigurerAdapter{

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("xing").setViewName("ws");
        registry.addViewController("login").setViewName("login");
        registry.addViewController("chat").setViewName("chat");
    }
}
