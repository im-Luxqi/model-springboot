package com.wxq.modelspringboot.web.controller;

import com.wxq.modelspringboot.web.entity.User;
import com.wxq.modelspringboot.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class HomeController {

    @Autowired
    private UserService userService;

    @GetMapping({"/", "/index", "/home"})
    public String root(){
        return "index";
    }

    @GetMapping("/login")
    public String login(){
        return "page_login/login";
    }


    @PostMapping("/register")
    public String doRegister(User user){
        // 此处省略校验逻辑
        if (userService.insert(user))
            return "redirect:/login?success";
        return "redirect:/login?error";
    }
}
