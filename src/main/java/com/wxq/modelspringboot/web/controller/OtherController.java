package com.wxq.modelspringboot.web.controller;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/user2")
public class OtherController {

    @GetMapping("canvasText")
    public String canvasText(){
        return "page_canvas/canvas_text";
    }
}
