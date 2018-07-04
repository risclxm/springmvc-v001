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
	
	

	@Override
	public boolean updatePassword(TSysUser user) {
		
		int count= TSysUserDao.updatePassword(user);
		if(count >0) {
			return true;
		}
		return false;
		
	}

	@Override
	public TSysUser getUser(TSysUser user) {
		return TSysUserDao.getUserByNameAndPwd(user);
	}

}
