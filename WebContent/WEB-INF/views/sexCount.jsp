<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>性别分析</title>
<!-- JQUERY -->
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
<body>
	<div class="layui-layout layui-layout-admin">
		<div class="layui-header">
			<div class="layui-header">
				<div class="layui-logo">12315投诉系统</div>
				<!-- 头部区域（可配合layui已有的水平导航） -->
				<ul class="layui-nav layui-layout-right">
					<li class="layui-nav-item"><a href="updateUser">用户资料</a></li>
					<li class="layui-nav-item"><a href="exit">退出</a></li>
				</ul>
			</div>
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
			<div style="padding: 15px;">性别分析</div>
			<div class="layui-inline">
				<label class="layui-form-label">开始日期 </label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test1" />
				</div>
			</div>
			<div class="layui-inline">
				<label class="layui-form-label">结束日期 </label>
				<div class="layui-input-inline">
					<input type="text" class="layui-input" id="test2" />
				</div>
			</div>
			<div class="layui-inline">
				<div class="layui-input-inline">
					<button id="submit_btn" class="layui-btn">提交</button>
				</div>
			</div>
			<!-- 为ECharts准备一个具备大小（宽高）的Dom -->
			<div id="main" style="height: 400px; padding: 20px;"></div>
		</div>
	</div>
	<script>
		
	</script>
	<script>
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//执行一个laydate实例
			laydate.render({
				elem : '#test1' //指定元素
			});
		});
	</script>
	<script>
		layui.use('laydate', function() {
			var laydate = layui.laydate;

			//执行一个laydate实例
			laydate.render({
				elem : '#test2' //指定元素
			});
		});
	</script>
	<script type="text/javascript">
		$(function() {
			function obj(value, name) {
				this.name = name;
				this.value = value;
			}
			$("#submit_btn")
					.on(
							'click',
							function(event) {
								console.log("1");
								// 基于准备好的dom，初始化echarts图表
								myChart = echarts.init(document
										.getElementById('main'));
								console.log("2");
								var option = {
									tooltip : {
										trigger : 'item',
										formatter : "{a} <br/>{b} : {c} ({d}%)"
									},

									series : [ {
										name : "投诉量",
										type : "pie",
										itemStyle : {
											emphasis : {
												shadowBlur : 10,
												shadowOffsetX : 0,
												shadowColor : 'rgba(0, 0, 0, 0.5)'
											}
										}

									} ]
								};
								var name = "a"
								var count = "0"
								var startTime = $("#test1").val();
								var endTime = $("#test2").val();

								;
								//console.log(time)
								$
										.ajax({
											type : "post",
											async : false, //同步执行
											url : "count_sex",
											data : JSON.stringify({
												name : name,
												startTime : startTime,
												endTime : endTime,
												count : count
											}),
											contentType : "application/json; charset=utf-8",
											dataType : "json", //返回数据形式为json
											success : function(result) {
												if (result) {

													//初始化option.series[0]中的data
													option.series[0].data = [];
													for (var i = 0; i < result.length; i++) {
														var a = new obj(
																result[i].count,
																result[i].name);
														console.log(a);
														option.series[0].data
																.push(a);
													}
												}
											}
										});
								// 为echarts对象加载数据 
								myChart.setOption(option);
							})
		})
	</script>
</body>
</html>