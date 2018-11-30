package com.wxq.modelspringboot.web.controller;

import com.wxq.modelspringboot.web.entity.City;
import com.wxq.modelspringboot.web.entity.City111;
import com.wxq.modelspringboot.web.service.CityService;
import com.wxq.modelspringboot.web.service.impl.City111ESServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 城市 Controller 实现 Restful HTTP 服务
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Controller
@RequestMapping("/api")
public class CityController {

    @Autowired
    private CityService cityService;
    @Autowired
    private City111ESServiceImpl city111ESServiceImpl;

    @GetMapping("city/{id}")
    public String findOneCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findCityById(id));
        return "city";
    }

    @GetMapping("city")
    public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList", cityList);
        return "cityList";
    }


    @RequestMapping(value = "/city111", method = RequestMethod.POST)
    @ResponseBody
    public Long addCity111(@RequestBody City111 city111) {
        return city111ESServiceImpl.saveCity(city111);
    }

    @RequestMapping(value = "/city111", method = RequestMethod.GET)
    @ResponseBody
    public List<City111> searchCity(@RequestParam String text) {
        return city111ESServiceImpl.searchCity(null, null, text);
    }
}
