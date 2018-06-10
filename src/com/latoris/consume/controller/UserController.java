package com.latoris.consume.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
		return "login";
	}
	
	@RequestMapping("/loginconfrim")
	public String userLogin(UserBean user, HttpServletRequest request) {
		UserBean result = userService.findUserByUsernameAndPass(user);
		System.out.println("结果"+user.toString());
		if(result.getName() != null) {
			HttpSession session = request.getSession();
            session.setAttribute("user", result);
            return "redirect:/showComplaint";
		}
		return "login";
	}

	//添加新动画
	@RequestMapping(value = "/adduser", method = RequestMethod.POST)
	public String save(UserBean user) {
		userService.addUser(user);
		return "login";
	}
	
	/*
	 * @Param id 
	 */
	@RequestMapping(value = "/updateUser", method = RequestMethod.GET)
	public String updateUser(HttpServletRequest request) {
				HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		request.setAttribute("user", user);
		//logger.addInfo("更新"+user.getName());
		return "updateUser";
	}

	
	@RequestMapping(value = "/updateUserPost", method = RequestMethod.POST)
	public String updateConfrim(UserBean user) {
		// 修改提交
		userService.updateUser(user, user.getUid());
		//logger.addInfo("更新"+user.getName()+"完成");
		return "redirect:/showComplaint";
	}

	@RequestMapping(value = "/exit")
	public String userQuit(HttpServletRequest request) {
		System.out.println("用户退出");
		HttpSession session=request.getSession();
		session.removeAttribute("user");
		System.out.println(session.getAttribute("user"));
		return "login";
	}
}
