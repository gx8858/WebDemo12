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
		// 获取对象
		var xhr = createXMLHttpRequest();
		// 链接资源
		xhr.open("GET","/test/ajax3",true);
		// 发送请求
		xhr.send(null);
		// 获取响应
		xhr.onreadystatechange = function(){
			// 双重判断
			if(xhr.readyState == 4 && xhr.status == 200){
				/**
					<stus>
						<stu name="zhangsan">
							<age>18</age>
						</stu>
					</stus>
				*/
				// 接收数据
				var doc = xhr.responseXML;	// 返回的是document对象
				// 获取stu的节点
				var stu = doc.getElementsByTagName("stu")[0];
				// 获取stu的属性
				var name = stu.getAttribute("name");
				// 获取age标签的文本内容
				var age = doc.getElementsByTagName("age")[0];
				// 获取age的文本内容
				
				var text;
				if(window.addEventListener){
					// 说明火狐等浏览器
					text = age.textContent;
				}else{
					// IE低版本
					text = age.text;
				}
				
				var msg = name+" "+text;
				document.getElementById("h3Id").innerHTML = msg;
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
<h3>响应的XML的数据内容</h3>

<button onclick="run()">我是按钮</button>
<h3 id="h3Id"></h3>


</body>
</html>