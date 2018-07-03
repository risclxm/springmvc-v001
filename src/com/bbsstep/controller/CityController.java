package com.bbsstep.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bbsstep.po.ActiveBean;
import com.bbsstep.po.CityBean;
import com.bbsstep.po.CityBeanVo;
import com.bbsstep.service.CityServiceInterface;
import com.bbsstep.service.TActiveServiceInterface;

@Controller
@RequestMapping("/city")
public class CityController {
	
	@Autowired
	private CityServiceInterface cityservice;
	
	@Autowired
	private TActiveServiceInterface activeService;
	
	@ResponseBody
	@RequestMapping(value="/mapcity.action",produces="application/json;charset=utf-8")
	public String getCityByName(String cityName) {
		CityBeanVo vo = new CityBeanVo();
		CityBean bean =cityservice.selectByCityName(cityName);
		List<ActiveBean> actives = activeService.selectActiveByCity(cityName);
		vo.setCity(bean);
		vo.setActives(actives);
		return JSON.toJSONString(vo);
		
	}

}
