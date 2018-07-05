package com.bbsstep.service;

import java.util.List;

import com.bbsstep.po.ActiveBean;
import com.bbsstep.util.DataTablePageUtil;

public interface TActiveServiceInterface {
	public int getMonthActiveCount () ;
	public int  getSumActiveCount();
	public int getDayActiveCount ();
	 List<ActiveBean> selectActiveByCity(String cityName);
	 
	//分页显示所有热点的活动信息
	 DataTablePageUtil<ActiveBean> selectHotActiveList(DataTablePageUtil<ActiveBean> param);
	 
}
