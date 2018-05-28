package com.latoris.consume.controller;

import java.util.List;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.latoris.consume.beans.ComplaintBean;
import com.latoris.consume.service.ComplaintServiceImpl;

@Controller
public class ComplaintController {
	
	@Autowired
	private ComplaintServiceImpl complaintService;
	
	@RequestMapping("/complaint")
	public String listall(HttpServletRequest request) {
			//logger.addInfo("list all");
			List<ComplaintBean> list = complaintService.findComplaint();
			System.out.println(list);
			request.setAttribute("Lists", list);
			return "listall2";
	}

	@RequestMapping(value = "/addComplaint")
	public String add() {
		return "input";
	}

	//添加新动画
	@RequestMapping(value = "/addComplaintPost", method = RequestMethod.POST)
	public String save(ComplaintBean complaint) {
		
		complaintService.addComplaint(complaint);
		return "redirect:/complaint";
	}
	
	/*
	 * @Param id 
	 */
	@RequestMapping(value = "/updateComplaint", method = RequestMethod.GET)
	public String updateComplaint(@RequestParam("id") int id, ComplaintBean complaint, HttpServletRequest request) {
		complaint = complaintService.findComplaintById(id);
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
