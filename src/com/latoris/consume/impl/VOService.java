package com.latoris.consume.impl;

import java.util.List;
import com.latoris.consume.beans.UserBean;
import com.latoris.consume.beans.VOBean;
import com.latoris.consume.mapper.UserMapper;
public interface VOService{
	
	public List<VOBean> CountByEnterprise(VOBean parameter);

	public List<VOBean> CountByAge(VOBean para);
	
}
