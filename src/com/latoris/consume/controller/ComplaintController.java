package com.latoris.consume.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latoris.consume.beans.ComplaintBean;
import com.latoris.consume.beans.UserBean;
import com.latoris.consume.beans.VOBean;
import com.latoris.consume.service.ComplaintServiceImpl;
import com.latoris.consume.service.VOServiceImpl;

@Controller
public class ComplaintController {
	 private static Logger log = LogManager.getLogger(ComplaintController.class.getName());
	
	@Autowired
	private ComplaintServiceImpl complaintService;
	
	@RequestMapping("/showComplaint")
	public String listall(HttpServletRequest request) {
			HttpSession session = request.getSession();
			UserBean user = (UserBean) session.getAttribute("user");
			System.out.println(user.toString());
			List<ComplaintBean> list = complaintService.findComplaintByUid(user.getUid());
			request.setAttribute("Lists", list);
			return "showComplaint";
	}

	@RequestMapping(value = "/addComplaint")
	public String add() {
		return "addComplaint";
	}

	
	@RequestMapping(value = "/addComplaintPost", method = RequestMethod.POST)
	public String save(@ModelAttribute ComplaintBean complaint,HttpServletRequest request) {
		System.out.println(complaint.toString());
		complaint.getAppeal_type().replaceAll(",", " ");
		HttpSession session = request.getSession();
		UserBean user = (UserBean) session.getAttribute("user");
		complaint.setUid(user.getUid());
		complaintService.addComplaint(complaint);
		return "redirect:/complaint";
	}
	
	/*
	 * @Param id 
	 */
	@RequestMapping(value = "/updateComplaint", method = RequestMethod.GET)
	public String updateComplaint(@RequestParam("id") long cid, ComplaintBean complaint, HttpServletRequest request) {
		complaint = complaintService.findComplaintByCid(cid);
		request.setAttribute("complaint", complaint);
		//logger.addInfo("更新"+complaint.getName());
		return "modify";
	}

	
	@RequestMapping(value = "/updateComplaintConfrim", method = RequestMethod.POST)
	public String updateConfrim(ComplaintBean complaint) {
		// 修改提交
		complaintService.updateComplaint(complaint, complaint.getUid());
		//logger.addInfo("更新"+complaint.getName()+"完成");
		return "redirect:/complaint";
	}

	@RequestMapping(value = "/delcomplaint")
	public String delete(@RequestParam("id") int id) {
		//logger.info("删除" + id);
		complaintService.delComplaintById(id);
		return "redirect:/complaint";
	}
}
