package com.bbsstep.mapper;

import org.springframework.stereotype.Repository;

import com.bbsstep.po.TSysUser;
@Repository
public interface TSysUserMapper {
	TSysUser CheckUserForLogin(TSysUser user);
	int updatePassword(TSysUser user);
}
