package com.bbsstep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbsstep.mapper.CityBeanMapper;
import com.bbsstep.po.CityBean;
import com.bbsstep.service.CityServiceInterface;

@Service
public class CityService implements CityServiceInterface {

	@Autowired
	private CityBeanMapper cityMaper;
	@Override
	public CityBean selectByCityName(String cityName) {
		return cityMaper.selectByCity(cityName);
	}

}
