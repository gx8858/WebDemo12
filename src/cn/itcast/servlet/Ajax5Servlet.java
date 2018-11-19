package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 返回json格式的数据
 * @author Administrator
 *
 */
public class Ajax5Servlet extends HttpServlet {

	private static final long serialVersionUID = 6967125344690990603L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 以后不需要自己拼接
		String msg = "{\"name\":\"zhangsan\",\"age\":18}";
		// 把数据响应前台
		response.getWriter().print(msg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}






