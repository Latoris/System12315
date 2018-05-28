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
<a href="add">新增</a>
<a>所有yognhu</a>
<table>
	<tr>
		<td>卡种类</td>
		<td>卡号</td>
		<td>性别</td>
		<td>生日</td>
		<td>名字</td>
		<td>用户名</td>
		<td>密码</td>
		<td>手机</td>
		<td>地址</td>
	</tr>
	<c:forEach var="list" items="${Lists}">
	<tr>
		<td>${list.card_type}</td>
    	<td>${list.card_num}</td>
    	<td>${list.sex}</td>
    	<td>${list.birthday}</td>
    	<td>${list.name}</td>
   		<td>${list.username}</td>
  		<td>${list.password}</td>
   		<td>${list.phone}</td>
    	<td>${list.addr}</td>
    	<td><a href="updateUser.action?id=${list.uid}">更新</a>&nbsp;&nbsp;&nbsp;&nbsp;<a href="delUser.action?id=${list.uid}">删除</a></td>
    </tr>
    </c:forEach>
</table>
</body>
</html>