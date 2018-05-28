package com.latoris.consume.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.latoris.consume.beans.ComplaintBean;
import com.latoris.consume.beans.VOBean;
import com.latoris.consume.impl.VOService;
import com.latoris.consume.service.ComplaintServiceImpl;
import com.latoris.consume.service.VOServiceImpl;

@Controller
public class ComplaintController {
	
	@Autowired
	private ComplaintServiceImpl complaintService;
	@Autowired
	private VOServiceImpl VOService;
	
	@RequestMapping("/count_enterprise")
	@ResponseBody
	public void countEnterprise(HttpServletRequest request, HttpServletResponse response, @RequestBody VOBean para) {
		// logger.addInfo("list all");
		System.out.println("count");
		System.out.println(para.getStartTime()+" "+para.getEndTime());
		List<VOBean> list = VOService.CountByEnterprise(para);
		response.setContentType("text/html; charset=utf-8");
		// 调用JSONArray.fromObject方法把array中的对象转化为JSON格式的数组
		
		JSONArray json = new JSONArray();
		for(int i = 0;i < list.size();i++) {
			JSONObject jo =new JSONObject();
			jo.put("eid", list.get(i).getName());
			jo.put("count", list.get(i).getCount());
			json.put(jo);
		}
		System.out.println(json.toString());
		// 返回给前段页面
		PrintWriter out;
		try {
			out = response.getWriter();
			out.println(json);
			out.flush();
			out.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}

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
