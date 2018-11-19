<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	// 发送异步的请求，获取数据
	function run(){
		// 获取XMLHttpRequest对象
		var xhr = createXMLHttpRequest();
		// 和服务器进行链接 open
		// 1）请求方式	2）请求资源的路径	3）是否是异步
		xhr.open("GET","/test/ajax1?username=zhangsan",true);
		// 发送请求 send
		// send参数：如果是GET请求，必须给出null。如果是POST请求，传入参数
		xhr.send(null);
		// 监听xhr的状态的改变
		xhr.onreadystatechange = function(){
			// 双重判断
			if(xhr.readyState == 4 && xhr.status == 200){
				// 接收数据
				var text = xhr.responseText;
				// 需要把text的内容显示到H3的标签中间
				document.getElementById("h3Id").innerHTML = text;
			}
		};
	}
	
	// 获取XMLHttpRequest对象
	function createXMLHttpRequest(){
		try {
			// 获取大多数浏览器
			return new XMLHttpRequest();
		} catch (e) {
			try {
				// 处理IE6.0
				return new ActiveXObject("Msxml2.XMLHTTP");
			} catch (e) {
				try {
					// 解决IE5.5一下版本
					return new ActiveXObject("Microsoft.XMLHTTP");	
				} catch (e) {
					throw e;
				}
			}
		}
	}



</script>

</head>
<body>
<h3>异步请求</h3>

<button onclick="run()">我是按钮</button>
<h3 id="h3Id"></h3>



</body>
</html>