package com.bbsstep.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bbsstep.po.ActiveBean;
import com.bbsstep.util.DataTablePageUtil;

@Repository
public interface TActiveMapper {
  int selectMonthActive();
  int selectSumActive();
  int selectDayActive();
  
 List<ActiveBean> selectActiveByCity(String cityName);
 
 
//分页显示所有热点的活动信息
 List<ActiveBean> selectHotActiveList(DataTablePageUtil<ActiveBean> param);
 
 int selectNumHotActiveList(DataTablePageUtil<ActiveBean> param);
}