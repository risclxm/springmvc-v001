package com.bbsstep.controller;

import java.util.List;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.bbsstep.po.Items;

public class ItemsController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest arg0, HttpServletResponse arg1) throws Exception {
		//��Ʒ�б�
				List<Items> itemsList = new ArrayList<Items>();
				
				Items items_1 = new Items();
				items_1.setName("����ʼǱ�");
				items_1.setPrice(6000f);
				items_1.setDetail("ThinkPad T430 ����ʼǱ����ԣ�");
				
				Items items_2 = new Items();
				items_2.setName("ƻ���ֻ�");
				items_2.setPrice(5000f);
				items_2.setDetail("iphone6ƻ���ֻ���");
				
				itemsList.add(items_1);
				itemsList.add(items_2);
				
				//����modelAndView׼��������ݡ�������ͼ
				ModelAndView modelAndView = new ModelAndView();
				
				//�������
				modelAndView.addObject("itemsList", itemsList);
				//��ͼ
				modelAndView.setViewName("order/itemsList");
				
				return modelAndView;
	}

}
