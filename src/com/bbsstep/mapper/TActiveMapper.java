package com.bbsstep.mapper;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.bbsstep.po.ActiveBean;

@Repository
public interface TActiveMapper {
  int selectMonthActive();
  int selectSumActive();
  int selectDayActive();
  
 List<ActiveBean> selectActiveByCity(String cityName);
}