<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.0.3.min.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
</head>
<body>
<a href="addComplaint">新增</a>
<a>所有投诉</a>
<table class="layui-table">
 	<colgroup>
    <col width="100">
    <col width="100">
    <col width="100">
    <col width="100">
    <col width="100">
    <col width="100">
    <col width="100">
    <col width="100">
    <col>
  	</colgroup>
	<thead>
	<tr>
		<td>用户id</td>
		<td>企业代码</td>
		<td>产品名</td>
		<td>产品类型</td>
		<td>提交时间</td>
		<td>诉求内容</td>
		<td>问题类型</td>
		<td>状态</td>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="list" items="${Lists}">
	<tr>
		<td>${list.uid}</td>
    	<td>${list.eid}</td>
    	<td>${list.merchandise_name}</td>
    	<td>${list.merchandise_type}</td>
    	<td>${list.submit_time}</td>
    	<td>${list.appeal_type}</td>
    	<td>${list.problem_type}</td>
    	<td>${list.status}</td>
    	<td><a href="updateUser?id=${list.cid}">详情或更改</a></td>
    </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>