package cn.itcast.servlet;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.Node;
import org.dom4j.io.SAXReader;

/**
 * 通过省份的信息获取该省下所有的城市
 * @author Administrator
 *
 */
public class CityServlet extends HttpServlet {

	private static final long serialVersionUID = 2252740058409685815L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * 接收参数
		 * 
		 */
		request.setCharacterEncoding("UTF-8");
		// 接收数据
		String pname = request.getParameter("pname");
		// 解析china.xml文件，通过pname来获取所有的城市信息
		// 获取china.xml文档的输入流
		InputStream in = CityServlet.class.getClassLoader().getResourceAsStream("china.xml");
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(in);
			
			// 实现XPATH
			// 传入过来的值类似北京  河北  吉林
			Node pnode = document.selectSingleNode("//province[@name='"+pname+"']");
			// 把node转换成字符串
			String text = pnode.asXML();
			
			System.out.println(text);
			
			// 想响应的是什么内容
			response.setContentType("text/xml;charset=UTF-8");
			// 向页面响应
			response.getWriter().print(text);
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
