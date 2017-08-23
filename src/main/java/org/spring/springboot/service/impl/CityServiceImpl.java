package org.spring.springboot.service.impl;

import org.spring.springboot.domain.City;
import org.spring.springboot.service.CityService;
import org.spring.springboot.service.base.BaseServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * 城市业务逻辑实现类
 *
 * Created by bysocket on 07/02/2017.
 */
@Service
@Transactional
public class CityServiceImpl extends BaseServiceImpl<City> implements CityService {


}
