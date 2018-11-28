package com.wxq.modelspringboot.web.Dao;

import com.wxq.modelspringboot.common.base.BaseRepository;
import com.wxq.modelspringboot.web.entity.City;

import java.util.List;

public interface CityRepository extends BaseRepository<City,String> {
    List<City> findByCityName(String cityName);
}
