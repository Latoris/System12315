package com.latoris.consume.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.latoris.consume.beans.UserBean;

public interface UserMapper {
	public void addUser(UserBean userBean);
	public void delUser(@Param(value="uid")int uid);
	public void updateUserById(@Param(value="User")UserBean User, @Param(value="id")long l);
	public List<UserBean> findUser();
	public UserBean findUserById(int uid);
	public UserBean findUserByUsernameAndPass(UserBean User);
}
