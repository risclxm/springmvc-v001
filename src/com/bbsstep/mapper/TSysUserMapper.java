package com.bbsstep.mapper;

import org.springframework.stereotype.Repository;

import com.bbsstep.po.TSysUser;
@Repository
public interface TSysUserMapper {
	TSysUser getUserByNameAndPwd(TSysUser user);
	String getPwdByName(String name);
	int updatePassword(TSysUser user);
}
