<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script type="text/javascript">
	
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
	
	// 用户输入完用户名名的时候，失去了焦点，触发事件
	// 获取用户输入的内容，偷偷的发送服务器端，偷偷的校验，把返回的结果显示到<span>的标签的中间
	function run(){
		// 创建对象
		var xhr = createXMLHttpRequest();
		// 打开链接
		xhr.open("POST","/test/reg",true);
		// 设置请求的头信息
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		// 发送请求
		// 带数据，先获取用户输入的数据
		var username = document.getElementById("nameId").value;
		xhr.send("username="+username);
		// 获取响应
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				// 可以获取响应的数据
				var text = xhr.responseText;
				// 向uspan的标签中间添加文本的内容
				var uspan = document.getElementById("uspan");
				uspan.innerHTML = text;
			}
		};
	}
	
	
</script>

</head>
<body>

<h3>注册的页面</h3>
<form action="" method="post">
	用户名：<input id="nameId" type="text" name="username" onblur="run()"/><span id="uspan"></span><br/>
	密码：<input type="password" name="password" /><br/>
	<input type="submit" value="注册" />
</form>

</body>
</html>








