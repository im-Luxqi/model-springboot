package com.wxq.modelspringboot.web.Dao;

import com.wxq.modelspringboot.common.base.BaseRepository;
import com.wxq.modelspringboot.web.entity.User;

import java.util.List;

public interface UserRepository extends BaseRepository<User, String> {
    List<User> findByName(String name);
}
