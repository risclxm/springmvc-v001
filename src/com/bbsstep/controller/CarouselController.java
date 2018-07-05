package com.bbsstep.controller;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.bbsstep.po.CarouselBean;
import com.bbsstep.po.TSysUser;
import com.bbsstep.service.CarouselBeanService;
import com.bbsstep.util.DataTablePageUtil;

@Controller
@RequestMapping("/carousel")
public class CarouselController {

	@Autowired
	private CarouselBeanService carouselBeanService;

	@RequestMapping("/list")
	@ResponseBody
	public DataTablePageUtil<CarouselBean> list(WebRequest request) {
		DataTablePageUtil<CarouselBean> dataTable = new DataTablePageUtil<CarouselBean>();
		// 设置查询类型为引导图
		dataTable.getCondition().put("type", "y");
		return carouselBeanService.list(dataTable);
	}

	@RequestMapping(value="/peacocklist.action",produces="application/json;charset=utf-8")
	@ResponseBody
	public String peacocklist(WebRequest request) {
		DataTablePageUtil<CarouselBean> dataTable = new DataTablePageUtil<CarouselBean>();
		// 设置查询类型为引导图
		dataTable.getCondition().put("type", "a");
		String peacocklistStr = JSON.toJSONString(carouselBeanService.list(dataTable));
		return peacocklistStr;
	}

	@RequestMapping("/peacockAdd.action")
	public ModelAndView peacockAdd(CarouselBean bean, MultipartFile myfiles, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		// 原始文件名称
		String pictureFile_name = myfiles.getOriginalFilename();
		// 新文件名称
		String newFileName = UUID.randomUUID().toString()
				+ pictureFile_name.substring(pictureFile_name.lastIndexOf("."));

		// 上传图片
		File uploadPic = new java.io.File("F:\\upload\\" + newFileName);

		if (!uploadPic.exists()) {
			uploadPic.mkdirs();
		}
		// 向磁盘写文件
		try {
			myfiles.transferTo(uploadPic);
		} catch (IllegalStateException | IOException e) {
			mv.addObject("msg", "引导图上传失败");
			e.printStackTrace();
		}
		bean.setPath("upload/" + newFileName);
		TSysUser user = (TSysUser) session.getAttribute("login");
		bean.setUserId(user.getId());
		String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
		bean.setCreatetime(time);
		bean.setEdittime(time);
		bean.setWeight(5);
		bean.setIschoose("f");
		bean.setType("a");

		// 保存到数据库
		try {
			int row = carouselBeanService.add(bean);
			if (row == 0) {
				mv.addObject("msg", "引导图新增失败");
			} else {
				mv.addObject("msg", "引导图新增成功");
			}
		} catch (Exception ex) {
			mv.addObject("msg", "引导图新增失败");
		}
		mv.setViewName("redirect:/pages/operconfig/peacock/peacock_list.jsp");
		return mv;
	}

}
