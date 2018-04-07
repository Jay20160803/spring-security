package com.jk51.springsecurity.config;

import com.jk51.springsecurity.service.MyUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;
@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)  //開啟註解驗證權限
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;
    @Autowired
    private MyUserDetailsService userDetailsService;

    /**
     * 指定验证表单
     * */
   @Override
   public void configure(HttpSecurity http) throws Exception {

       http
               .authorizeRequests()
                    .antMatchers("/static/**","/index").permitAll()
                    .antMatchers("/user/**").hasRole("USER")

               .and()
               .formLogin()
                    .loginPage("/login").failureUrl("/login-error");
                   // .permitAll();

   }

    @Autowired
    public void configureClobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder());
    }

    /**
     * 创建PasswordEncoder Bean
     * */
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    /**
     * 创建AuthenticationManager Bean
     * */
    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    /**
     * Java 配置和表单登录
     * 没有指定表单是，是用Security默认的表单
     * 没有指定账户和密码时，使用的账户为user，密码会打印在启动日志中
     *
     * */
   /* @Override
    public void configure(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()
                    .anyRequest().authenticated()   //设置访问所有的请求都需要已经认证
                    .and()
                .formLogin()
                .and()
                .httpBasic();   //使用默认表单认证
    }*/

    /*   *//**
     * 使用数据库验证
     * *//*
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .jdbcAuthentication()
                .dataSource(dataSource)
                .usersByUsernameQuery("select username,password,enabled "
                        + "from user " + "where username = ?") //定义自己的sql查询用户表，取代默认的查询sql
                .passwordEncoder(passwordEncoder());
               // .withUser("user").password("password").roles("USER")
               // .and().withUser("admin").password("password").roles("USER","ADMIN");
    }*/
}
