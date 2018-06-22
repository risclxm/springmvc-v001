package com.bbsstep.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.bbsstep.po.Items;

@Controller
public class Items2Controller {
	
	@RequestMapping("/queryItem.action")
	public ModelAndView queryItem() {
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

		// ����modelAndView׼��������ݡ�������ͼ
		ModelAndView modelAndView = new ModelAndView();

		// �������
		modelAndView.addObject("itemsList", itemsList);
		// ��ͼ
		modelAndView.setViewName("order/itemsList");

		return modelAndView;
	}
	
	/**
	 * ����ת��
	 * @param request
	 * @param response
	 * @throws Exception
	 */
	@RequestMapping(value="/returnnull.action")
	public void returnNull(HttpServletRequest request,HttpServletResponse response) throws Exception{
		
		//����service��ѯ��Ʒ��Ϣ
		List<Items> itemsList = new ArrayList<Items>();

		Items items_1 = new Items();
		items_1.setName("����ʼǱ�1");
		items_1.setPrice(6000f);
		items_1.setDetail("ThinkPad T430 ����ʼǱ����ԣ�");

		Items items_2 = new Items();
		items_2.setName("ƻ���ֻ�1");
		items_2.setPrice(5000f);
		items_2.setDetail("iphone6ƻ���ֻ���");

		itemsList.add(items_1);
		itemsList.add(items_2);
		
		request.setAttribute("itemsList", itemsList);
		
		request.getRequestDispatcher("WEB-INF/jsp/order/itemsList.jsp").forward(request, response);;
	}
	//---------������------------------------------����
	//http://localhost:8081/springmvc-v001/editItem.action?id=3
		@RequestMapping(value="/editItem")
		public String editItem(Model model, Integer id) throws Exception{
			System.out.println("��ò���ֵΪ��"+id);
			return "order/itemsList";
		}
		//http://localhost:8081/springmvc-v001/editItemSubmit.action?id=1&name=productname&price=2.1&detail=this%20is%20a%20goods
		@RequestMapping("/editItemSubmit")
		public String editItemSubmit(Items items)throws Exception{
			
         System.out.println("��õĲ���ֵΪ��"+items);
			
			
			return "order/itemsList";
		}
		//http://localhost:8081/springmvc-v001/getParamBydifferentName.action?name=123
		@RequestMapping("/getParamBydifferentName")
		public String getParamBydifferentName(@RequestParam(value="name",required=true) String usename)throws Exception{
			
         System.out.println("��õĲ���ֵΪ��"+usename);
			
			
			return "order/itemsList";
		}
		
		//http://localhost:8081/springmvc-v001/getTimeParam.action?id=1&name=productname&price=2.1&createtime=2018-09-09%2012:09:09
		//http://localhost:8081/springmvc-v001/getTimeParam.action?id=1&name=productname&price=2.1&createtime=2018/09/09
				@RequestMapping("/getTimeParam")
				public String getTimeParam(Items items)throws Exception{
					
		         System.out.println("��õĲ���ֵΪ��"+items);
					
					
					return "order/itemsList";
				}
		
}
