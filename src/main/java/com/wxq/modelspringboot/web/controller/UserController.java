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

    @GetMapping("/user/canvasText")
    public String canvasText(){
        return "page_canvas/canvas_text";
    }

    @GetMapping("/user/canvasGameFiveChess")
    public String canvasGameFiveChess(){
        return "page_canvas/canvas_game_fiveChess";
    }

    @GetMapping("/user/canvasGameTank")
    public String canvasGameTank(){
        return "page_canvas/canvas_game_tank";
    }

    @GetMapping("/user/canvasGameSnake")
    public String canvasGameSnake(){
        return "page_canvas/canvas_game_snake";
    }

    @GetMapping("/user/canvasSmallBall")
    public String canvasSamllBall(){
        return "page_canvas/canvas_smallBall";
    }
    @GetMapping("/user/canvasHeart")
    public String canvasHeart(){
        return "page_canvas/canvas_heart";
    }
    @GetMapping("/user/canvasLoveTime")
    public String canvasLoveTime(){
        return "page_canvas/canvas_loveTime";
    }
    @GetMapping("/user/jasper")
    public String jasper(){
        return "page_jasper/jasper";
    }






    public void print(){

    }

}
