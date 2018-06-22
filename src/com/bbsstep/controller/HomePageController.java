package com.bbsstep.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.bbsstep.service.TActiveServiceInterface;
import com.bbsstep.service.TUserServiceInterface;

@Controller
@RequestMapping(value="/homepage")
public class HomePageController {
	@Autowired
	TUserServiceInterface tUserService;
	@Autowired
	TActiveServiceInterface tActiveService;
	
	@RequestMapping(value="/count.action" ,method=RequestMethod.GET)
	@ResponseBody
	public String  getCount() {
		Map<String,Integer> map = new HashMap<String,Integer>();
		int dayUserCount = tUserService.getDayUserCount();
		int monthUserCount = tUserService.getMothoUserCount();
		int AllUserCount = tUserService.getAllUserCount();
		int dayActiveCount = tActiveService.getDayActiveCount();
		int monthActiveCount = tActiveService.getMonthActiveCount();
		int allActiveCount = tActiveService.getSumActiveCount();
		map.put("dayUserCount", dayUserCount);
		map.put("monthUserCount", monthUserCount);
		map.put("AllUserCount", AllUserCount);
		map.put("dayActiveCount",dayActiveCount );
		map.put("monthActiveCount",monthActiveCount );
		map.put("allActiveCount",allActiveCount );
		 
		return JSON.toJSONString(map);
	}

}
