package com.bbsstep.controller;


import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.bbsstep.po.CarouselBean;
import com.bbsstep.service.CarouselBeanService;
import com.bbsstep.util.DataTablePageUtil;



@Controller
public class CarouselController {

	@Autowired
	private CarouselBeanService carouselBeanService;
	
	@RequestMapping("/carousel/list")
	@ResponseBody
	public DataTablePageUtil<CarouselBean> list(WebRequest request){
		DataTablePageUtil<CarouselBean> dataTable = new DataTablePageUtil<CarouselBean>(request); 
		//设置查询类型为引导图
		dataTable.getCondition().put("type", "y");
		return carouselBeanService.list(dataTable);
	}
	
	@RequestMapping("/carousel/peacocklist.action")
	@ResponseBody
	public String peacocklist(WebRequest request){
		DataTablePageUtil<CarouselBean> dataTable = new DataTablePageUtil<CarouselBean>(request); 
		//设置查询类型为引导图
		dataTable.getCondition().put("type", "a");
		String peacocklistStr = JSON.toJSONString(carouselBeanService.list(dataTable));
		return peacocklistStr;
	}
	
	
}
