<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
			<ul class="layui-nav layui-layout-right">
				<li class="layui-nav-item"><a href="updateUser">用户资料</a>
					</li>
				<li class="layui-nav-item"><a href="exit">退出</a></li>
			</ul>
		</div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
		<li class="layui-nav-item"><a href="">发起投诉</a></li>
        <li class="layui-nav-item"><a href="showComplaint">查看投诉</a></li>
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
	<form class="layui-from" action="${pageContext.request.contextPath}/addComplaintPost" method="post">
		<input name="cid" value="0" hidden/>
		<input name="uid" value="0" hidden/>
		<div class="layui-form-item">
			<label class="layui-form-label">公司统一社会信用代码 </label>
			<div class="layui-input-inline">
				<input type="text" name="eid" class="layui-input"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">产品名称 </label>
			<div class="layui-input-inline">
				<input type="text" name="merchandise_name" class="layui-input"/>
			</div>
			<label class="layui-form-label">产品类型 </label>
			<div class="layui-input-inline">
				<input type="text" name="merchandise_type" class="layui-input"/>
			</div>
		</div>
		<input name="submit_time" value=<%=new java.sql.Timestamp(System.currentTimeMillis()).toString()%> hidden/>
		<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">发生日期 </label>
			<div class="layui-input-inline">
				<input type="text" class="layui-input" id="happen_time" name="happen_time"/>
			</div>
		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">购买方式</label>
			<div class="layui-input-inline">
			<select name="purchase_way" lay-filter="purchaseWay">
				<option value=""></option>
				<option value="1">网购</option>
				<option value="2" selected="">线下</option>
				<option value="3">电话</option>
				<option value="4">邮购</option>
				<option value="5">其他</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">问题类型</label>
			<div class="layui-input-block">
			<select name="problem_type" id="problem_type" lay-filter="problemType">
				<option value=""></option>
				<option value="1">质量</option>
				<option value="2" selected="">广告</option>
				<option value="3">3</option>
				<option value="4">4</option>
				<option value="5">5</option>
			</select>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">投诉内容</label>
			<div class="layui-input-block">
				<input type="text" name="complaint_content" class="layui-input"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">诉求类型</label>
			<div class="layui-input-block">
				<input type="checkbox" id="appeal1" name="appeal_type" value="重做">重做
				<input type="checkbox" id="appeal2" name="appeal_type" value="退换"> 退换
				<input type="checkbox" id="appeal3" name="appeal_type" value="更换"> 更换
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">数量 </label>
			<div class="layui-input-inline">
				<input type="text" name="count" class="layui-input"/>
			</div>
			<label class="layui-form-label">金额 </label>
			<div class="layui-input-inline">
				<input type="text" name="amount" class="layui-input"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">处理工商ID</label>
			<div class="layui-input-inline">
				<input type="text" name="iid" class="layui-input"/>
			</div>
		</div>
		<input name="status" value="0" hidden/>
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
});    
</script>
<script>
layui.use('laydate', function(){
  var laydate = layui.laydate;
  
  //执行一个laydate实例
  laydate.render({
    elem: '#happen_time' //指定元素
  });
});
</script>
<script>
//JavaScript代码区域
layui.use('element', function(){
  var element = layui.element;
  
});
</script>
<script src="${pageContext.request.contextPath}/resources/layui/lay/modules/form.js" charset="utf-8"></script>
</body>
</html>