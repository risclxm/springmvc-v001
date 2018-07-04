package com.bbsstep.realm;

import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import com.bbsstep.mapper.TSysUserMapper;

public class CustomerRealm extends AuthorizingRealm{

	@Autowired
	private TSysUserMapper TSysUserDao;
	@Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken arg0) throws AuthenticationException {
		String username = (String) arg0.getPrincipal();
		// 根据用户名，从数据库中获取凭证
		String userpassword = getPasswordByUserName(username);
		if (userpassword == null) {
			return null;
		}
		SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(username, userpassword,
				"customrealm");
		return simpleAuthenticationInfo;
	}

	private String getPasswordByUserName(String username) {
	
		return TSysUserDao.getPwdByName(username);
	}
}
