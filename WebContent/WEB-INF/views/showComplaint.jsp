<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<script
	src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.0.3.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/echarts.min.js"></script>
<script type="text/javascript"
	src="${pageContext.request.contextPath}/resources/js/require.js"></script>
<script
	src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<link rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
</head>
<body class="layui-layout-body">
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-logo">12315投诉系统</div>
			<!-- 头部区域（可配合layui已有的水平导航） -->
			<ul class="layui-nav layui-layout-left">
				<li class="layui-nav-item"><a href="">控制台</a></li>
				<li class="layui-nav-item"><a href="">商品管理</a></li>
				<li class="layui-nav-item"><a href="">用户</a></li>
				<li class="layui-nav-item"><a href="javascript:;">其它系统</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">邮件管理</a>
						</dd>
						<dd>
							<a href="">消息管理</a>
						</dd>
						<dd>
							<a href="">授权管理</a>
						</dd>
					</dl></li>
			</ul>
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="updateUser">贤心</a>
					<dl class="layui-nav-child">
						<dd>
							<a href="">个人资料</a>
						</dd>
						<dd>
							<a href="updateUser">账户设置</a>
						</dd>
					</dl></li>
				<li class="layui-nav-item"><a href="exit">退出</a></li>
			</ul>
		</div>

		<div class="layui-side layui-bg-black">
			<div class="layui-side-scroll">
				<!-- 左侧导航区域（可配合layui已有的垂直导航） -->
				<ul class="layui-nav layui-nav-tree" lay-filter="test">
					<li class="layui-nav-item"><a href="addComplaint">发起投诉</a></li>
					<li class="layui-nav-item"><a href="showComplaint">查看投诉</a></li>
					<li class="layui-nav-item layui-nav-itemed"><a class="">统计分析</a>
						<dl class="layui-nav-child">
							<dd>
								<a href="allCount">总数分析</a>
							</dd>
							<dd>
								<a href="typeCount">类别分析</a>
							</dd>
							<dd>
								<a href="enterpriseCount">公司分析</a>
							</dd>
							<dd>
								<a href="sexCount">性别分析</a>
							</dd>
							<dd>
								<a href="ageCount">年龄分析</a>
							</dd>
						</dl></li>
				</ul>
			</div>
		</div>
		<div class="layui-body">
		<div style="padding: 15px;">投诉列表</div>
			<table class="layui-table" style="padding: 15px;">
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
							<td>${list.eid}</td>
							<td>${list.merchandise_name}</td>
							<td>${list.merchandise_type}</td>
							<td>${list.submit_time}</td>
							<td>${list.appeal_type}</td>
							<td>${list.problem_type}</td>
							<td>${list.status}</td>
							<td><a href="updateComplaint?id=${list.cid}">详情或更改</a></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
</body>
</html>