package cn.itcast.servlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import cn.itcast.utils.MyJdbcUtil;
import cn.itcast.vo.User;

/**
 * �ж��û����Ƿ��Ѿ�����servlet�������ݿ⣩ 
 */
public class RegServlet extends HttpServlet {

	private static final long serialVersionUID = 2882227455185170387L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ��������
		String username = request.getParameter("username");
		// ��д��ѯ�û����Ķ���ķ���
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		response.setContentType("text/html;charset=UTF-8");
		try {
			User user = runner.query("select * from t_user where username = ? ", new BeanHandler<User>(User.class), username);
			// û�ҵ����û���������
			if(user == null){
				// ����ע��
				response.getWriter().write("<font color='green'>����ע��</font>");
			}else{
				// �û�������
				response.getWriter().write("<font color='red'>�û����Ѿ�����</font>");
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
