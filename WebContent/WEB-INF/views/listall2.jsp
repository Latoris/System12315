<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
</head>
<body>
<a href="addComplaint">新增</a>
<a>所有投诉</a>
<table>
	<tr>
		<td>uid</td>
		<td>eid</td>
		<td>产品名</td>
		<td>提交时间</td>
		<td>诉求内容</td>
	</tr>
	<c:forEach var="list" items="${Lists}">
	<tr>
		<td>${list.uid}</td>
    	<td>${list.eid}</td>
    	<td>${list.merchandise_name}</td>
    	<td>${list.submit_time}</td>
    	<td>${list.appeal_type}</td>
    	<td><a href="updateUser.action?id=${list.cid}">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delUser.action?id=${list.cid}">删除</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>