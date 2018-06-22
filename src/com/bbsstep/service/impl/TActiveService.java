package com.bbsstep.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbsstep.mapper.TActiveMapper;
import com.bbsstep.po.ActiveBean;
import com.bbsstep.service.TActiveServiceInterface;



@Service
public class TActiveService implements TActiveServiceInterface {
	@Autowired
	TActiveMapper mapper;
	
	public int getMonthActiveCount () {
		return mapper.selectMonthActive();
	}
	public int  getSumActiveCount() {
		return mapper.selectSumActive();
	}
	public int getDayActiveCount () {
		return mapper.selectDayActive();
	}
	@Override
	public List<ActiveBean> selectActiveByCity(String cityName) {
		return mapper.selectActiveByCity(cityName);
	}

}
