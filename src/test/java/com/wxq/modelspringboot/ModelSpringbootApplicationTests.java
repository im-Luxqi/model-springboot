package com.wxq.modelspringboot;

import com.wxq.modelspringboot.common.configBean.ConfigTest1Properties;
import com.wxq.modelspringboot.web.Dao.CityRepository;
import com.wxq.modelspringboot.web.controller.UserController;
import com.wxq.modelspringboot.web.entity.City;
import com.wxq.modelspringboot.web.entity.User;
import com.wxq.modelspringboot.web.Dao.UserRepository;
import com.wxq.modelspringboot.web.service.CityService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ModelSpringbootApplicationTests {
    private MockMvc mvc;

    @Autowired
    private ConfigTest1Properties blogProperties;
    @Test
    public void contextLoads() {
        System.out.println(blogProperties.getName());
    }


    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UserController()).build();
    }





    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CityRepository cityRepository;

    @Autowired
    private CityService cityService;

    @Test
    public void test() throws Exception {


        List<City> l = cityRepository.findByCityName("上海");

        System.out.println(l.get(0).getId());

//        City city = new City();
//        city.setCityName("上海");
//        User user = new User();
//        user.setAge(26);
//        user.setName("熊涛");
//        user.setCity(city);
//
//        cityRepository.save(city);
//        userRepository.save(user);
//         userRepository.findByName("AAA");
//        System.out.println(userRepository.findByName("AAA").get(0).getAge());
//        Assert.assertEquals("10",userRepository.findByName("AAA").get(0).getAge());

    }
}
