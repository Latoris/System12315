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
import com.latoris.consume.service.VOServiceImpl;

@Controller
public class VOController {
	 private static Logger log = LogManager.getLogger(VOController.class.getName());

	@Autowired
	private VOServiceImpl VOService;
	
	@RequestMapping("/enterpriseCount")
	public String enterprise() {
		return "enterpriseCount";
	}
	
	@RequestMapping("/count_enterprise")
	@ResponseBody
	public void countEnterprise(HttpServletRequest request, HttpServletResponse response, @RequestBody VOBean para) {
		System.out.println("count");
		System.out.println(para.getStartTime()+" "+para.getEndTime());
		List<VOBean> list = VOService.CountByEnterprise(para);
		response.setContentType("text/html; charset=utf-8");
		JSONArray json = convertToJson(list);
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
		JSONArray json = convertToJson(list);
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
	
	@RequestMapping("/sexCount")
	public String sex() {
		return "sexCount";
	}
	
	@RequestMapping("/count_sex")
	@ResponseBody
	public void countSex(HttpServletRequest request, HttpServletResponse response, @RequestBody VOBean para) {
		System.out.println("count");
		System.out.println(para.getStartTime()+" "+para.getEndTime());
		List<VOBean> list = VOService.CountBySex(para);
		response.setContentType("text/html; charset=utf-8");
		JSONArray json = convertToJson(list);
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
	
	@RequestMapping("/allCount")
	public String all() {
		return "submitTimeCount";
	}
	
	@RequestMapping("/count_submitTime")
	@ResponseBody
	public void countSubmitTime(HttpServletRequest request, HttpServletResponse response, @RequestBody VOBean para) {
		System.out.println("count");
		System.out.println(para.getStartTime()+" "+para.getEndTime());
		List<VOBean> list = VOService.CountBySubmitTime(para);
		response.setContentType("text/html; charset=utf-8");
		JSONArray json = convertToJson(list);
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
	
	@RequestMapping("/typeCount")
	public String type() {
		return "typeFirstCount";
	}
	
	@RequestMapping("/count_typeFirst")
	@ResponseBody
	public void countTypeFirst(HttpServletRequest request, HttpServletResponse response, @RequestBody VOBean para) {
		System.out.println("count");
		System.out.println(para.getStartTime()+" "+para.getEndTime());
		List<VOBean> list = VOService.CountByTypeFirst(para);
		response.setContentType("text/html; charset=utf-8");
		JSONArray json = convertToJson(list);
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
	
	public JSONArray convertToJson(List<VOBean> list) {
		JSONArray json = new JSONArray();
		for(int i = 0;i < list.size();i++) {
			JSONObject jo =new JSONObject();
			jo.put("name", list.get(i).getName());
			jo.put("count", list.get(i).getCount());
			json.put(jo);
		}
		return json;
	}
}
