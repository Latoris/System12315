<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <!-- JQUERY -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery/jquery-2.0.3.min.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/echarts.min.js">
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/require.js">
    </script>
</head>
<body>
    <!-- 为ECharts准备一个具备大小（宽高）的Dom -->
    <div id="main" style="width: 600px;height:400px;"></div>
    <script type="text/javascript">
                console.log("1");
                // 基于准备好的dom，初始化echarts图表
                myChart = echarts.init(document.getElementById('main')); 
                console.log("2");
                var option = {
                		 title:{
                             text:'ECharts 数据统计'
                         },
                    tooltip: {
                        //show: true
                    },
                    legend: {
                        data:['数量']
                    },
                    xAxis : [
                        {
                            type : 'category',
                            
                        }
                    ],
                    yAxis :{},
                    series : [
                        {
                            "name":"销量",
                            "type":"bar",
                            
                        }
                    ]
                };
                var name="a"
                var count="0"
                var startTime="2018-04-01";
            	var endTime="2018-04-02";
            	//console.log(time)
                $.ajax({
                   type : "post",
                   async : false, //同步执行
                   url : "count_enterprise",
                   data :  JSON.stringify({  
                       name: name,  
                       startTime: startTime,  
                       endTime: endTime,  
                       count : count}),  
                   contentType: "application/json; charset=utf-8",
                   dataType : "json", //返回数据形式为json
                   success : function(result) {
                              if (result) {
                                     //初始化option.xAxis[0]中的data
                                      option.xAxis[0].data=[];
                                      for(var i=0;i<result.length;i++){
                                        option.xAxis[0].data.push(result[i].name);
                                      }
                                      //初始化option.series[0]中的data
                                      option.series[0].data=[];
                                      for(var i=0;i<result.length;i++){
                                        option.series[0].data.push(result[i].num);
                                      }
                               }
                            }
                });     
                // 为echarts对象加载数据 
                myChart.setOption(option); 
           
       
    </script>
</body>
</html>