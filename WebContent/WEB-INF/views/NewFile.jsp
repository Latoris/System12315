<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
    <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8">
    <title>ECharts</title>
    <script type="text/javascript" src="${pageContext.request.contextPath}/resources/js/echarts.min.js">
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
                            data : ["衬衫","羊毛衫","雪纺衫","裤子","高跟鞋","袜子"]
                            
                        }
                    ],
                    yAxis :{},
                    series : [
                        {
                            "name":"销量",
                            "type":"bar",
                            "data":[5, 20, 40, 10, 10, 20]
                            
                        }
                    ]
                };
                //加载数据
                //loadDATA(option);
                // 为echarts对象加载数据 
                myChart.setOption(option); 
            
    
       
    </script>
</body>
</html>