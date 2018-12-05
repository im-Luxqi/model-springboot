package com.wxq.modelspringboot;

import com.wxq.modelspringboot.common.configBean.ConfigTest1Properties;
import com.wxq.modelspringboot.web.controller.UserController;
import com.wxq.modelspringboot.web.Dao.UserRepository;
import com.wxq.modelspringboot.web.entity.User;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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


    @Test
    public void test() throws Exception {

        User user = new User();
        User user2 = new User();
        user.setUsername("tom");
        user.setNickname("tom");
        user.setPassword("123");
        user.setRoles("ROLE_USER");

        user2.setUsername("admin");
        user2.setNickname("admin");
        user2.setPassword("123");
        user2.setRoles("ROLE_USER,ROLE_ADMIN");


        userRepository.save(user2);
        userRepository.save(user);

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


    @Test
    public void test2() {
        String pwd = "123456Aa";
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        // 加密
        String encodedPassword = passwordEncoder.encode(pwd);
        System.out.println("【加密后的密码为：】" + encodedPassword);
    }
}
