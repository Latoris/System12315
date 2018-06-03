package com.latoris.consume.impl;

import java.util.List;
import com.latoris.consume.beans.UserBean;
import com.latoris.consume.mapper.UserMapper;
public interface UserService{

	public List<UserBean> findUser();
	
	public UserBean findUserById(Integer id);
	

	public UserBean findUserByUsernameAndPass(UserBean User);
	
	public void addUser(UserBean User);

	public void updateUser(UserBean User, long id) ;

	public void delUserById(int id);
}
