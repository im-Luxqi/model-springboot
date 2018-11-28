package com.wxq.modelspringboot.web.controller;

import com.wxq.modelspringboot.web.entity.City;
import com.wxq.modelspringboot.web.service.CityService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

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

    @ApiOperation(value="id查找指定城市")
    @ApiImplicitParam(name = "id", value = "城市id", required = true, dataType = "Long")
    @RequestMapping(value = "city/{id}", method = RequestMethod.GET)
    public String findOneCity(Model model, @PathVariable("id") Long id) {
        model.addAttribute("city", cityService.findCityById(id));
        return "city";
    }
    @ApiOperation(value = "查找所有城市")
    @RequestMapping(value = "city", method = RequestMethod.GET)
    public String findAllCity(Model model) {
        List<City> cityList = cityService.findAllCity();
        model.addAttribute("cityList", cityList);
        return "cityList";
    }
}
