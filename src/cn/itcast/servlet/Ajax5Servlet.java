package cn.itcast.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * ����json��ʽ������
 * @author Administrator
 *
 */
public class Ajax5Servlet extends HttpServlet {

	private static final long serialVersionUID = 6967125344690990603L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// �Ժ���Ҫ�Լ�ƴ��
		String msg = "{\"name\":\"zhangsan\",\"age\":18}";
		// ��������Ӧǰ̨
		response.getWriter().print(msg);
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}
}






