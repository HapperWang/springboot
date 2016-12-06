package com.xing.springBoot_02;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

/**
 * Created by 汪东兴 on 2016-12-5.
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter{

    @Override
   public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity.authorizeRequests()
                .antMatchers("/", "login").permitAll()// 设置Spring Security对/和/"login"不拦截
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login") //设置Spring Security的登陆页面访问路径是/login
                .defaultSuccessUrl("/chat")//登陆成功后跳转的路径
                .permitAll().and().logout().permitAll();
    }

    /**
     * 在内存中分别配置两个用户并指定密码，角色是USER
     * @autor 汪东兴
     * @date 2016-12-05 10:49:47
     * @param builder
     * @throws Exception
     */

    @Override
    public void configure(AuthenticationManagerBuilder builder) throws Exception {
        builder.inMemoryAuthentication()
                .withUser("wangdongxing").password("123456").roles("USER")
                .and()
                .withUser("admin").password("123456").roles("USER");
    }

    /**
     * 静态资源不拦截
     * @autor 汪东兴
     * @date 2016-12-05 10:55:19
     * @param security
     * @throws Exception
     */
    @Override
    public void configure(WebSecurity security) throws Exception {
        security.ignoring().antMatchers("resources/static/**");
    }

}
