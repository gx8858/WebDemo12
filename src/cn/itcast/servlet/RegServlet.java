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
 * 判断用户名是否已经存在servlet（查数据库） 
 */
public class RegServlet extends HttpServlet {

	private static final long serialVersionUID = 2882227455185170387L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 接收数据
		String username = request.getParameter("username");
		// 编写查询用户名的对象的方法
		QueryRunner runner = new QueryRunner(MyJdbcUtil.getDataSource());
		response.setContentType("text/html;charset=UTF-8");
		try {
			User user = runner.query("select * from t_user where username = ? ", new BeanHandler<User>(User.class), username);
			// 没找到，用户名不存在
			if(user == null){
				// 可以注册
				response.getWriter().write("<font color='green'>可以注册</font>");
			}else{
				// 用户名存在
				response.getWriter().write("<font color='red'>用户名已经存在</font>");
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
