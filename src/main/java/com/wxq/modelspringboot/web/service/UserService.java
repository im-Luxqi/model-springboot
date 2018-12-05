package com.wxq.modelspringboot.web.service;

import com.wxq.modelspringboot.web.entity.User;


public interface UserService {

    /**
     * 添加新用户
     * <p>
     * username 唯一， 默认 USER 权限
     */
    Boolean insert(User user);

    /**
     * 查询用户信息
     *
     * @param username 账号
     * @return UserEntity
     */
    User getByUsername(String username);

}
