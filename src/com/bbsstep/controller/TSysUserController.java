package com.bbsstep.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AccountException;
import org.apache.shiro.authc.CredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
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
		
		String original =(String) session.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		if(!original.equalsIgnoreCase(code.trim())){
			logger.info("验证码输入错误");
			mv.addObject("msg","验证码输入错误");
			mv.setViewName("redirect:/login.jsp?msg=1");
		}else{
			
			Subject subject = SecurityUtils.getSubject();
			UsernamePasswordToken token = new UsernamePasswordToken(username, password);
			try {
			  subject.login(token);
			}catch(AccountException e) {
				logger.info("账号错误");
				mv.addObject("msg","账号错误");
				mv.setViewName("redirect:/login.jsp?msg=1");
				return mv;
			}catch(CredentialsException e) {
				logger.info("账号错误");
				mv.addObject("msg","凭证错误");
				mv.setViewName("redirect:/login.jsp?msg=1");
				return mv;
			}
			logger.info("用户:"+username+"登陆成功");
			TSysUser user = new TSysUser();
			password=MDUtil.GetMD5Code(password);
			user.setPassword(password);
			user.setUsername(username);
			TSysUser loginUser=service.getUser(user);
			session.setAttribute("login", loginUser);
			mv.setViewName("redirect:/pages/home/index.jsp");
			
			
		}
		return mv;
	}
	@RequestMapping(value="/tsysuser/updatepwd.action" ,method=RequestMethod.POST)
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
