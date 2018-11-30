package com.wxq.modelspringboot.web.controller;

import com.wxq.modelspringboot.web.Dao.UserRepository;
import com.wxq.modelspringboot.web.entity.User;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    // 创建线程安全的Map
    static Map<String, User> users = Collections.synchronizedMap(new HashMap<String, User>());

    @Autowired
    private UserRepository userRepository;


    @GetMapping("/")
    public List<User> getUserList() {
        // 处理"/users/"的GET请求，用来获取用户列表
        // 还可以通过@RequestParam从页面中传递参数来进行查询条件或者翻页信息的传递
        List<User> r = new ArrayList<User>(users.values());
        return r;
    }

    @ApiImplicitParam(name = "user", required = true, dataType = "User")
    @PostMapping("/")
    public String addUser(@ModelAttribute User user) {
        // 处理"/users/"的POST请求，用来创建User
        // 除了@ModelAttribute绑定参数之外，还可以通过@RequestParam从页面中传递参数
        users.put(user.getId(), user);
        return "success";
    }


    @ApiImplicitParam(name = "id", required = true, dataType = "Long")
    @GetMapping("/{id}")
    public User getUser(@PathVariable Long id) {
        // 处理"/users/{id}"的GET请求，用来获取url中id值的User信息
        // url中的id可通过@PathVariable绑定到函数的参数中

//        return userRepository.findByName("xiaoming").get(0);
        return users.get(id);
    }


    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", required = true, dataType = "Long"),
            @ApiImplicitParam(name = "user", required = true, dataType = "User")
    })
    @PutMapping("/{id}")
    public String updateUser(@PathVariable String id, @ModelAttribute User user) {
        // 处理"/users/{id}"的PUT请求，用来更新User信息
        User u = users.get(id);
        u.setName(user.getName());
        u.setAge(user.getAge());
        users.put(id, u);
        return "success";
    }


    @ApiImplicitParam(name = "id", dataType = "Long", required = true)
    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Long id) {
        // 处理"/users/{id}"的DELETE请求，用来删除User
        users.remove(id);
        return "success";
    }
}
