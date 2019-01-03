package com.wxq.modelspringboot.web.controller;

import com.wxq.modelspringboot.common.utils.JasperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.security.Principal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    private  JasperUtils jasperUtils;
    @GetMapping("dashboard")
    public String user(@AuthenticationPrincipal Principal principal, Model model){
        model.addAttribute("username", principal.getName());
        return "page_dashboard/dashboard";
    }

    @GetMapping("canvasText")
    public String canvasText(){
        return "page_canvas/canvas_text";
    }

    @GetMapping("canvasGameFiveChess")
    public String canvasGameFiveChess(){
        return "page_canvas/canvas_game_fiveChess";
    }

    @GetMapping("canvasGameTank")
    public String canvasGameTank(){
        return "page_canvas/canvas_game_tank";
    }

    @GetMapping("canvasGameSnake")
    public String canvasGameSnake(){
        return "page_canvas/canvas_game_snake";
    }

    @GetMapping("canvasSmallBall")
    public String canvasSamllBall(){
        return "page_canvas/canvas_smallBall";
    }
    @GetMapping("canvasHeart")
    public String canvasHeart(){
        return "page_canvas/canvas_heart";
    }
    @GetMapping("canvasLoveTime")
    public String canvasLoveTime(){
        return "page_canvas/canvas_loveTime";
    }
    @GetMapping("commonWork")
    public String jasper(){
        return "page_commonWork/commonWork";
    }

    @GetMapping("print")
    public void print(String type,String jasperName,String nickName,
                      HttpServletRequest request, HttpServletResponse response){


        Map<String,Object> map = new HashMap<String,Object>();
        map.put("idK","a");
            jasperUtils.printFile(type,jasperName,nickName,map,request,response);
    }

}
