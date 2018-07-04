package com.bbsstep.service;

import com.bbsstep.po.TSysUser;

public interface TsysUserServiceInteface {

	TSysUser getUser(TSysUser user);
	 boolean updatePassword(TSysUser user);

}
