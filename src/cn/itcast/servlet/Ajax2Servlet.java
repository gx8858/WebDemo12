package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ajax�Ļ�������post
 */
public class Ajax2Servlet extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ���ղ���
		String username = request.getParameter("username");
		System.out.println("(POST)hello ajax! "+username);
		// ��ͻ���������Ӧ
		response.getWriter().print("(POST)hello ajax!!! "+username);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
