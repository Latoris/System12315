package com.latoris.consume.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.latoris.consume.beans.UserBean;
import com.latoris.consume.beans.VOBean;
import com.latoris.consume.impl.UserService;
import com.latoris.consume.impl.VOService;
import com.latoris.consume.mapper.CountMapper;
import com.latoris.consume.mapper.UserMapper;
@Service
public class VOServiceImpl implements VOService{
	
	@Autowired
	private CountMapper mapper;

	@Override
	public List<VOBean> CountByEnterprise(VOBean para) {
		// TODO Auto-generated method stub
		return mapper.CountByEnterprise(para);
	}
	
	@Override
	public List<VOBean> CountByAge(VOBean para) {
		// TODO Auto-generated method stub
		return mapper.CountByAge(para);
	}
	
	@Override
	public List<VOBean> CountBySex(VOBean para) {
		// TODO Auto-generated method stub
		return mapper.CountBySex(para);
	}
	@Override
	public List<VOBean> CountBySubmitTime(VOBean para) {
		// TODO Auto-generated method stub
		return mapper.CountBySubmitTime(para);
	}
	@Override
	public List<VOBean> CountByTypeFirst(VOBean para) {
		// TODO Auto-generated method stub
		return mapper.CountByTypeFirst(para);
	}
}