package com.bbsstep.mapper;

import com.bbsstep.po.CityBean;

public interface CityBeanMapper {
	CityBean selectByCity(String cityName);
}
