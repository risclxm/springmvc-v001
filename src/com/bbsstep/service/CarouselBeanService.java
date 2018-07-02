package com.bbsstep.service;


import com.bbsstep.po.CarouselBean;
import com.bbsstep.util.DataTablePageUtil;


public interface CarouselBeanService {

	public DataTablePageUtil<CarouselBean> list(DataTablePageUtil<CarouselBean> param);
	
	public int add(CarouselBean record);
	
	
}
