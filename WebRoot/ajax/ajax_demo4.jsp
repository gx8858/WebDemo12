<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>省市联动</title>

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
		
	// 页面一加载完成，把所有的省份的信息，添入到<select name="province" id="psel">中
	function run(){
		// 获取XMLHttpRequest对象
		var xhr = createXMLHttpRequest();
		// 和服务器进行链接 open
		// 1）请求方式	2）请求资源的路径	3）是否是异步
		xhr.open("GET","/test/province",true);
		// 发送请求 send
		// send参数：如果是GET请求，必须给出null。如果是POST请求，传入参数
		xhr.send(null);
		// 监听xhr的状态的改变
		xhr.onreadystatechange = function(){
			// 双重判断
			if(xhr.readyState == 4 && xhr.status == 200){
				// 获取psel的对象
				var psel = document.getElementById("psel");
				// 接收数据
				var text = xhr.responseText;
				// text返回北京,天津....
				// 返回所有的省份名称的数组
				var ps = text.split(",");
				for(var i = 0;i < ps.length;i++){
					// 循环获取省份的名称（第一个是北京）
					var pname = ps[i];
					// 创建option的节点对象
					var option = document.createElement("option");
					// 设置节点的属性
					option.value = pname;
					// 需要在option下添加文本节点
					var textNode = document.createTextNode(pname);
					// 把文件的节点添加到option节点的下面
					option.appendChild(textNode);
					// 把option的节点添加到	<select name="province" id="psel">
					psel.appendChild(option);
					// 想办法把数据填入到<select name="province" id="psel">
				}
			}
		};
	}
	
	// 获取省份的信息，发送后台，获取该省份下所有的城市的信息
	function show(val){
		// alert(val);
		// 向服务器端发送
		// 获取XMLHttpRequest对象
		var xhr = createXMLHttpRequest();
		// 和服务器进行链接 open
		// 1）请求方式	2）请求资源的路径	3）是否是异步
		xhr.open("POST","/test/city",true);
		// 设置请求头
		xhr.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
		// 发送请求 send
		// send参数：如果是GET请求，必须给出null。如果是POST请求，传入参数
		xhr.send("pname="+val);
		// 监听xhr的状态的改变
		xhr.onreadystatechange = function(){
			if(xhr.readyState == 4 && xhr.status == 200){
				// 先获取csel对象
				var csel = document.getElementById("csel");
				// 清除掉csel下面的所有子节点
				// 获取所有的子节点
				var options = csel.getElementsByTagName("option");
				// 判断长度只要大于一一直循环删除
				while(options.length > 1){
					// 删除第一个位置
					csel.removeChild(options[1]);
				}
				
				/**
				<province name="北京">
					<city>东城区</city>
					<city>西城区</city>	
				</province>
				*/
				// 接收数据的内容
				var doc = xhr.responseXML;  // Document对象
				
				// 获取city下的所有的城市的内容
				var citys = doc.getElementsByTagName("city");
				// 循环遍历
				for(var i=0;i<citys.length;i++){
					var city = citys[i];
					// 东城区
					var data;
					// 获取city的文本内容
					if(window.addEventListener){
						// 我是火狐
						data = city.textContent;
					}else{
						// 我是IE低版本
						data = city.text;
					}
					// 添加到<select name="city" id="csel">
					var option = document.createElement("option");
					option.value = data;
					var textNode = document.createTextNode(data);
					option.appendChild(textNode);
					// 把option添加到csel中
					csel.appendChild(option);
				}
			}
		};
		
	}
	
</script>

</head>
<body onload="run()">

<h3>省市联动</h3>

<select name="province" id="psel" onchange="show(this.value)">
	<option value="">--请选择--</option>
</select>

<select name="city" id="csel">
	<option value="">--请选择--</option>
</select>

</body>
</html>