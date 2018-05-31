<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
  <title>layout 后台大布局 - Layui</title>
  <link rel="stylesheet" href="${pageContext.request.contextPath}/resources/layui/css/layui.css">
</head>
<body class="layui-layout-body">
<div class="layui-layout layui-layout-admin">
  <div class="layui-header">
    <div class="layui-logo">layui 后台布局</div>
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
        <a href="javascript:;">
          <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
          贤心
        </a>
        <dl class="layui-nav-child">
          <dd><a href="">基本资料</a></dd>
          <dd><a href="">安全设置</a></dd>
        </dl>
      </li>
      <li class="layui-nav-item"><a href="">退了</a></li>
    </ul>
  </div>
  
  <div class="layui-side layui-bg-black">
    <div class="layui-side-scroll">
      <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
      <ul class="layui-nav layui-nav-tree"  lay-filter="test">
		<li class="layui-nav-item"><a href="">发起投诉</a></li>
        <li class="layui-nav-item"><a href="">查看投诉</a></li>
        <li class="layui-nav-item layui-nav-itemed">
          <a class="" href="javascript:;">统计分析</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="javascript:;">列表三</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        <li class="layui-nav-item">
          <a href="javascript:;">账户信息</a>
          <dl class="layui-nav-child">
            <dd><a href="javascript:;">列表一</a></dd>
            <dd><a href="javascript:;">列表二</a></dd>
            <dd><a href="">超链接</a></dd>
          </dl>
        </li>
        
      </ul>
    </div>
  </div>
  
  <div class="layui-body">
    <!-- 内容主体区域 -->
    <div style="padding: 15px;">添加投诉</div>
	<form class="layui-from" method="post" modelAttribute="ComplaintBean">
		<div class="layui-form-item">
			<label class="layui-form-label">产品名称 </label>
			<div class="layui-input-inline">
				<input type="text" id="productName" class="layui-input"/>
			</div>
			<label class="layui-form-label">产品类型 </label>
			<div class="layui-input-inline">
				<input type="text" class="layui-input"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">公司统一社会信用代码 </label>
			<div class="layui-input-inline">
				<input type="text" class="layui-input"/>
			</div>
		</div>
		<div class="layui-form-item">
		<div class="layui-inline">
			<label class="layui-form-label">发生日期 </label>
			<div class="layui-input-inline">
				<input type="text" class="layui-input" id="test1"/>
			</div>
		</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">购买方式</label>
			<div class="layui-input-inline">
			<select name="purchaseWay" lay-filter="purchaseWay">
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
			<select name="problemType" lay-filter="problemType">
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
				<input type="text" class="layui-input"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">诉求类型</label>
			<div class="layui-input-block">
				<input type="checkbox" id="appeal1" name="" title="重做">重做
				<input type="checkbox" id="appeal2" name="" title="退换"> 退换
				<input type="checkbox" id="appeal3" name="" title="更换"> 更换
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">数量 </label>
			<div class="layui-input-inline">
				<input type="text" class="layui-input"/>
			</div>
			<label class="layui-form-label">金额 </label>
			<div class="layui-input-inline">
				<input type="text" id="amount" class="layui-input"/>
			</div>
		</div>
		<div class="layui-form-item">
			<label class="layui-form-label">处理工商ID</label>
			<div class="layui-input-inline">
				<input type="text" id="iid" class="layui-input"/>
			</div>
		</div>
		<div class="layui-form-item">
		<div class="layui-input-block">
			<button class="layui-btn" lay-submit lay-filter="formDemo">立即提交</button>
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
    elem: '#test1' //指定元素
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