package com.bbsstep.service;

import java.util.List;

import com.bbsstep.po.ActiveBean;
import com.bbsstep.util.DataTablePageUtil;

public interface TActiveServiceInterface {
	public int getMonthActiveCount () ;
	public int  getSumActiveCount();
	public int getDayActiveCount ();
	 List<ActiveBean> selectActiveByCity(String cityName);
	 
	//��ҳ��ʾ�����ȵ�Ļ��Ϣ
	 DataTablePageUtil<ActiveBean> selectHotActiveList(DataTablePageUtil<ActiveBean> param);
	 
}
