package com.bbsstep.service;

import java.util.List;

import com.bbsstep.po.ActiveBean;

public interface TActiveServiceInterface {
	public int getMonthActiveCount () ;
	public int  getSumActiveCount();
	public int getDayActiveCount ();
	 List<ActiveBean> selectActiveByCity(String cityName);
}
