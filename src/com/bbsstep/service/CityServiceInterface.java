package com.bbsstep.service;

import com.bbsstep.po.CityBean;

public interface CityServiceInterface {
	CityBean selectByCityName(String cityName);
}
