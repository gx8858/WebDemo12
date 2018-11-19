<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>请求到json数据解析</title>

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
	

	// 定义json的格式	
	var person = {"name":"zhangsan","age":18};
	// 操作json的对象
	// alert(person.name +" "+person.age);
	
	var person2 = [{"name":"zhangsan","age":18},{"name":"zhaosi","age":20}];
	// alert(person2[1].name+" "+person2[1].age);
	
	var person3 = {"sex":[{"nan":"男","nv":"女","nannv":29}]};
	// alert(person3.sex[0].nan);
	
	
	// 异步的请求后台的数据
	function run(){
		// 获取XMLHttpRequest对象
		var xhr = createXMLHttpRequest();
		// 和服务器进行链接 open
		// 1）请求方式	2）请求资源的路径	3）是否是异步
		xhr.open("GET","/test/ajax5",true);
		// 发送请求 send
		// send参数：如果是GET请求，必须给出null。如果是POST请求，传入参数
		xhr.send(null);
		// 监听xhr的状态的改变
		xhr.onreadystatechange = function(){
			// 双重判断
			if(xhr.readyState == 4 && xhr.status == 200){
				// 接收数据
				var text = xhr.responseText;
				// 接收json格式的数据，解析数据
				// 需要先使用eval函数运行一下
				alert(text);
				var person = eval("("+text+")");
				alert(person);
				// 返回person json对象
				alert(person.name+" "+person.age);
			}
		};
	}
	
	
	
</script>

</head>
<body>
	<button onclick="run()">我是按钮</button>

</body>
</html>