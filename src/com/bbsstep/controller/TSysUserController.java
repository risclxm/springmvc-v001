package com.bbsstep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.bbsstep.po.TSysUser;
import com.bbsstep.service.TsysUserServiceInteface;
import com.bbsstep.util.MDUtil;
import com.google.code.kaptcha.Constants;





@Controller
@RequestMapping(value="/tsysuser")
public class TSysUserController extends BaseController{
	@Autowired
	TsysUserServiceInteface service ;
	/**
	 * @param username
	 * @param password
	 * @param request
	 * @return
	 */
	@RequestMapping("/managerlogin")
	public ModelAndView login(
			@RequestParam(value = "username", required = true) String username,
			@RequestParam(value = "password", required = true) String password,
			@RequestParam(value = "imageContent", required = false) String code,
			HttpServletRequest request,
			HttpSession session) {
		ModelAndView mv = new ModelAndView();
		password=MDUtil.GetMD5Code(password);
		String original =(String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(!original.equalsIgnoreCase(code.trim())){
			logger.info("验证码输入错误");
			mv.addObject("msg","验证码输入错误");
			mv.setViewName(""
					+ "?msg=0");
		}else{
			TSysUser user = new TSysUser();
			user.setPassword(password);
			user.setUsername(username);
			TSysUser loginUser=service.checkUser(user);
			if(loginUser!=null){
				logger.info("用户:"+username+"登陆成功");
				session.setAttribute("login", loginUser);
				mv.setViewName("redirect:/pages/home/index.jsp");
			}else{
				logger.info("用户:"+username+"登陆失败，用户名或密码错误");
				mv.addObject("msg","用户名或密码错误");
				mv.setViewName("redirect:/login.jsp?msg=1");
			}
		}
		return mv;
	}
	@RequestMapping(value="/updatepwd.action" ,method=RequestMethod.POST)
	@ResponseBody
	public String updatePassword(String password,HttpSession session) {
		String str="更新失败";
		TSysUser user = (TSysUser) session.getAttribute("login");
		user.setPassword(MDUtil.GetMD5Code(password));
		boolean flag =service.updatePassword(user);
		if(flag) {
			str="更新成功！";
		}
		
		return JSON.toJSONString(str);
		
	}

}
