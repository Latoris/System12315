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
	
	
	@RequestMapping("/user")
	public String listall(HttpServletRequest request) {
			List<UserBean> list = userService.findUser();
			request.setAttribute("Lists", list);
			return "listall";
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

	@RequestMapping(value = "/exit")
	public String userQuit(HttpServletRequest request) {
		System.out.println("用户退出");
		HttpSession session=request.getSession();
		session.removeAttribute("user");
		System.out.println(session.getAttribute("user"));
		return "login";
	}
}
