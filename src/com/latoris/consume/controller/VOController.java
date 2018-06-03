package com.latoris.consume.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
import com.latoris.consume.beans.VOBean;
import com.latoris.consume.service.ComplaintServiceImpl;
import com.latoris.consume.service.VOServiceImpl;

@Controller
public class VOController {
	 private static Logger log = LogManager.getLogger(VOController.class.getName());

	@Autowired
	private VOServiceImpl VOService;
	
	@RequestMapping("/enterpriseCount")
	public String table() {
		return "enterpriseCount";
	}
	
	@RequestMapping("/count_enterprise")
	@ResponseBody
	public void countEnterprise(HttpServletRequest request, HttpServletResponse response, @RequestBody VOBean para) {
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
			e.printStackTrace();
		} 
	}
	
	@RequestMapping("/ageCount")
	public String age() {
		return "ageCount";
	}
	
	@RequestMapping("/count_age")
	@ResponseBody
	public void countAge(HttpServletRequest request, HttpServletResponse response, @RequestBody VOBean para) {
		System.out.println("count");
		System.out.println(para.getStartTime()+" "+para.getEndTime());
		List<VOBean> list = VOService.CountByAge(para);
		response.setContentType("text/html; charset=utf-8");
		// 调用JSONArray.fromObject方法把array中的对象转化为JSON格式的数组
		JSONArray json = new JSONArray();
		for(int i = 0;i < list.size();i++) {
			JSONObject jo =new JSONObject();
			jo.put("age", list.get(i).getName());
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
			e.printStackTrace();
		} 
	}
}
