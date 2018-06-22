package com.bbsstep.po;

import java.util.List;

public class CityBeanVo{
	
	private CityBean city;

	public CityBean getCity() {
		return city;
	}

	public void setCity(CityBean city) {
		this.city = city;
	}

	private List<ActiveBean> actives;

	public List<ActiveBean> getActives() {
		return actives;
	}

	public void setActives(List<ActiveBean> actives) {
		this.actives = actives;
	}	
	
}
