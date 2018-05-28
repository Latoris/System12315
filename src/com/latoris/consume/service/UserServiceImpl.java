package com.latoris.consume.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.latoris.consume.beans.UserBean;
import com.latoris.consume.impl.UserService;
import com.latoris.consume.mapper.UserMapper;
@Service
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserMapper mapper;
	
	@Override
	public List<UserBean> findUser(){
		return mapper.findUser();
		
	}
	@Override
	public UserBean findUserById(Integer id){
		UserBean user = (UserBean) mapper.findUserById(id);
		return user;
	}
	@Override
	public void addUser(UserBean User) {
		if(User != null){
			mapper.addUser(User);
		}
		
	}
	@Override
	public void updateUser(UserBean User, int id) {
		mapper.updateUserById(User, id);
	}
	@Override
	public void delUserById(int id) {
		// TODO Auto-generated method stub
		mapper.delUser(id);
	}
	@Override
	public UserBean findUserByUsernameAndPass(UserBean user) {
		// TODO Auto-generated method stub
		return mapper.findUserByUsernameAndPass(user);
	}
}
