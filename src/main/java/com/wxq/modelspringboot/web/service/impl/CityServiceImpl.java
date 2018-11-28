package com.wxq.modelspringboot.web.service.impl;

import com.wxq.modelspringboot.web.Dao.CityMapper;
import com.wxq.modelspringboot.web.Dao.CityRepository;
import com.wxq.modelspringboot.web.entity.City;
import com.wxq.modelspringboot.web.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 城市业务逻辑实现类
 * <p>
 * Created by bysocket on 07/02/2017.
 */
@Service
public class CityServiceImpl implements CityService {

    @Autowired
    private CityMapper cityMapper;
    @Autowired
    private CityRepository cityRepository;

    public List<City> findAllCity() {
        return cityRepository.findAll();
    }

    public City findCityById(Long id) {
        return cityMapper.findById(id);
    }

    @Override
    public Long saveCity(City city) {
        return cityMapper.saveCity(city);
    }

    @Override
    public Long updateCity(City city) {
        return cityMapper.updateCity(city);
    }

    @Override
    public Long deleteCity(Long id) {
        return cityMapper.deleteCity(id);
    }

}
