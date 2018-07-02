package com.bbsstep.mapper;

import java.util.List;

import com.bbsstep.po.CarouselBean;
import com.bbsstep.util.DataTablePageUtil;

public interface CarouselBeanMapper {

	List<CarouselBean> selectByParam(DataTablePageUtil<CarouselBean> dataTablePageUtil);

	int selectNumByParam(DataTablePageUtil<CarouselBean> param);

	int insert(CarouselBean bean);

}
