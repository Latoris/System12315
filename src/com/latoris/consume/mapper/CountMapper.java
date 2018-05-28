package com.latoris.consume.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.latoris.consume.beans.VOBean;

public interface CountMapper {
	public List<VOBean> CountByEnterprise(@Param(value="para") VOBean para);
}
