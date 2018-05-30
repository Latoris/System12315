package com.latoris.consume.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.latoris.consume.beans.UserBean;
import com.latoris.consume.service.UserServiceImpl;

@Controller
public class UserController {
	
	@Autowired
	private UserServiceImpl userService;
	
	@RequestMapping("/login")
	public String user(HttpServletRequest request) {
		return "listall2";
	}
	
	@RequestMapping("/loginconfrim")
	public String userLogin(UserBean user) {
		UserBean result = userService.findUserByUsernameAndPass(user);
		if(result != null) {
			return "listall2";
		}
		//request.setAttribute(, arg1);
		return "listall";
	}
	
	@RequestMapping("/user")
	public String listall(HttpServletRequest request) {
			//logger.addInfo("list all");
			List<UserBean> list = userService.findUser();
			System.out.println(list);
			request.setAttribute("Lists", list);
			return "listall";
	}

	@RequestMapping(value = "/add")
	public String add() {
		return "input";
	}

	//添加新动画
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String save(UserBean user) {
		userService.addUser(user);
		return "redirect:/user";
	}
	
	/*
	 * @Param id 
	 */
	@RequestMapping(value = "/updateuser", method = RequestMethod.GET)
	public String updateUser(@RequestParam("id") int id, UserBean user, HttpServletRequest request) {
		user = userService.findUserById(id);
		request.setAttribute("user", user);
		//logger.addInfo("更新"+user.getName());
		return "modify";
	}

	
	@RequestMapping(value = "/updateConfrim", method = RequestMethod.POST)
	public String updateConfrim(UserBean user) {
		// 修改提交
		userService.updateUser(user, user.getUid());
		//logger.addInfo("更新"+user.getName()+"完成");
		return "redirect:/user";
	}

	@RequestMapping(value = "/deluser")
	public String delete(@RequestParam("id") int id) {
		//logger.info("删除" + id);
		userService.delUserById(id);
		return "redirect:/user";
	}
}
