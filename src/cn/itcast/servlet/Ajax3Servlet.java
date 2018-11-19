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
		
		// XML��ʽ�ַ���
		String xml = "<stus><stu name='zhangsan'><age>18</age></stu></stus>";
		// ������Ӧͷ��Ϣ
		response.setContentType("text/xml;charset=UTF-8");
		// ��Ӧ���ͻ�����
		response.getWriter().write(xml);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
