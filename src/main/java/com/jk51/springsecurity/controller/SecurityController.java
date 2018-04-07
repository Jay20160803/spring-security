package com.jk51.springsecurity.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@Controller
public class SecurityController {


    @RequestMapping("hi")
    @ResponseBody
    public String hi(){
        return "hi";
    }

    @RequestMapping("/")
    public String root(){

        return "redirect:/index";
    }
    @RequestMapping("/index")
    public String index(){
        return "index";
    }

    @RequestMapping("user/index")
    public String userIndex(){
        return "user/index";
    }
    @RequestMapping("login")
    public String login(){
        return "login";
    }
    @RequestMapping("login-error")
    public String loginError(Model model){
        model.addAttribute("loginError",true);
        return "login";
    }
}
