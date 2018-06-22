package com.bbsstep.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bbsstep.mapper.TUserMapper;
import com.bbsstep.po.TSysUser;
import com.bbsstep.service.TUserServiceInterface;



@Service
public class TUserService implements TUserServiceInterface {
	@Autowired
	TUserMapper mapper;
	
	public int getDayUserCount() {
		return mapper.selectDayUser();
		
	}
	public int getMothoUserCount() {
		return mapper.selectMonthUser();
		
	}
	public int getAllUserCount() {
		return mapper.selectAllUser();
	}
	
}
