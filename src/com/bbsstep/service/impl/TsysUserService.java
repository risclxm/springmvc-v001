package com.bbsstep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bbsstep.mapper.TSysUserMapper;
import com.bbsstep.po.TSysUser;
import com.bbsstep.service.TsysUserServiceInteface;

@Service
public class TsysUserService implements TsysUserServiceInteface{

	@Autowired
	private TSysUserMapper TSysUserDao;
	
	@Transactional
	public TSysUser checkUser(TSysUser user) {
		
		return TSysUserDao.CheckUserForLogin(user);
	}

	@Override
	public boolean updatePassword(TSysUser user) {
		
		int count= TSysUserDao.updatePassword(user);
		if(count >0) {
			return true;
		}
		return false;
		
	}

}
