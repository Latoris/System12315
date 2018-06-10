<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
       <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>添加投诉</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
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
      <li class="layui-nav-item">
        <a href="javascript:;">其它系统</a>
        <dl class="layui-nav-child">
          <dd><a href="">邮件管理</a></dd>
          <dd><a href="">消息管理</a></dd>
          <dd><a href="">授权管理</a></dd>
        </dl>
      </li>
    </ul>
    <ul class="layui-nav layui-layout-right">
      <li class="layui-nav-item">
        <a href="javascript:;">贤心</a>
        <dl class="layui-nav-child">
          <dd><a href="">个人资料</a></dd>
          <dd><a href="">账户设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="exit">退出</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
		<li class="layui-nav-item"><a href="">发起投诉</a></li>
        <li class="layui-nav-item"><a href="showuser">查看投诉</a></li>
        <li class="layui-nav-item layui-nav-itemed">
          <a class="">统计分析</a>
          <dl class="layui-nav-child">
            <dd><a href="allCount">总数分析</a></dd>
            <dd><a href="typeCount">类别分析</a></dd>
            <dd><a href="enterpriseCount">公司分析</a></dd>
            <dd><a href="sexCount">性别分析</a></dd>
            <dd><a href="ageCount">年龄分析</a></dd>
          </dl>
        </li>
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">添加投诉</div>
	<form class="layui-from" action="${pageContext.request.contextPath}/updateUserPost" method="post">
		<input name="uid" value="${user.uid}" hidden/>
		<div class="layui-form-item">
			<label class="layui-form-label">证件种类</label>
			<div class="layui-input-inline">
				<select value="${user.card_type}"  name="card_type" lay-filter="card_type">
				<option value=""></option>
				<option value="1" selected="">居民身份证</option>
				<option value="2" >护照</option>
				</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">证件号码 </label>
			<div class="layui-input-inline">
				<input type="text" name="cardnum" class="layui-input value="${user.card_num}" readonly"/>
			</div>
		</div>
		<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">性别</label>
			<div class="layui-input-inline">
				<input value="${user.sex}" type="text" class="layui-input" name="sex"/>
			</div>
			<label class="layui-form-label">出生日期 </label>
			<div class="layui-input-inline">
				<input value="${user.birthday}" type="text" class="layui-input" id="birthday" name="birthday"/>
			</div>
			<label class="layui-form-label">姓名</label>
			<div class="layui-input-inline">
				<input type="text" name="name" class="layui-input value=" value="${user.name}"/>
			</div>
		</div>
		</div>
		<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">用户名</label>
			<div class="layui-input-inline">
				<input value="${user.username}" type="text" class="layui-input" name="username"/>
			</div>
			<label class="layui-form-label">密码 </label>
			<div class="layui-input-inline">
				<input type="text" name="password" class="layui-input" value="${user.password}"/>
			</div>
		</div>
		</div>
		<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">手机号</label>
			<div class="layui-input-inline">
				<input value="${user.phone}" type="text" class="layui-input" name="phone"/>
			</div>
		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">地址</label>
			<div class="layui-input-block" >
				<input type="text" name="addr" value="${user.addr}" class="layui-input"/>
			</div>
		</div>
		<div class="layui-form-item">
		<div class="layui-input-block">
			<input type="submit" class="layui-btn" value="提交"/>
		</div>
		</div>
		
	</form>
  </div>

</div>
<script src="${pageContext.request.contextPath}/resources/layui/layui.js"></script>
<script>
layui.use('form', function(){
  var form = layui.form; //只有执行了这一步，部分表单元素才会自动修饰成功
  form.render(); //更新全部
  form.render('select'); 
});    
</script>
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#birthday' //指定元素
  });
});
</script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
</body>
</html>