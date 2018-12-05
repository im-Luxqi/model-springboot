package com.wxq.modelspringboot.web.service.impl;

import com.wxq.modelspringboot.common.constant.RoleConstant;
import com.wxq.modelspringboot.web.Dao.UserRepository;
import com.wxq.modelspringboot.web.entity.User;
import com.wxq.modelspringboot.web.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public Boolean insert(User user) {
        if (getByUsername(user.getUsername())!=null) return false;
        encryptPassword(user);
        user.setRoles(RoleConstant.ROLE_USER);
        userRepository.save(user);
        return true;
    }


    @Override
    public User getByUsername(String username) {
        List<User> users = userRepository.findByUsername(username);
        User user = null;
        if (!CollectionUtils.isEmpty(users)) {
            user = users.get(0);
        }
        return user;
    }

    /**
     * 加密密码
     */
    private void encryptPassword(User user){
        String password = user.getPassword();
        password = new BCryptPasswordEncoder().encode(password);
        user.setPassword(password);
    }
}
