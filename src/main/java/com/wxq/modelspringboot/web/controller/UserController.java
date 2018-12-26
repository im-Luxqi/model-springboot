package com.wxq.modelspringboot.web.controller;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class UserController {

    @GetMapping("/user/dashboard")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "page_dashboard/dashboard";
    }
    @GetMapping("/user/dashboard2")
    public String user2(Model model){
//        model.addAttribute("username", principal.getName());
        return "page_dashboard/dashboard2";
    }

    @GetMapping("/user/canvasText")
    public String canvasText(Model model){
        return "page_canvas/canvas_text";
    }

}
