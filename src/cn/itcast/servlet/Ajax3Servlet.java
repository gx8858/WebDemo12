package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ajax3Servlet extends HttpServlet {

	private static final long serialVersionUID = 5467760712271476224L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// XML格式字符串
		String xml = "<stus><stu name='zhangsan'><age>18</age></stu></stus>";
		// 设置响应头信息
		response.setContentType("text/xml;charset=UTF-8");
		// 响应到客户端上
		response.getWriter().write(xml);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
