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
import org.dom4j.io.SAXReader;

/**
 * 获取所有的省份的信息
 * @author Administrator
 *
 */
public class ProvinceServlet extends HttpServlet {
	
	private static final long serialVersionUID = -252171226830148479L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// 处理中文的乱码（响应）
		response.setContentType("text/html;charset=UTF-8");
		// 使用DOM4J的解析XML文件
		SAXReader reader = new SAXReader();
		// 获取china.xml文档的输入流
		InputStream in = ProvinceServlet.class.getClassLoader().getResourceAsStream("china.xml");
		// 解析XML文档，获取Document对象
		try {
			/**
			 <china>
				<province name="北京">
					<city>东城区</city>
					<city>西城区</city>
				</province>
				<province name="天津">
					<city>和平区</city>
					<city>河东区</city>
				</province>
			<china>
			 * 
			 */
			Document document = reader.read(in);
			// 获取所有的省份的信息
			// 先获取根节点
			Element root = document.getRootElement();
			// 获取province的节点
			List<Element> provinces = root.elements("province");
			StringBuffer sb = new StringBuffer();
			// 循环遍历
			for (int i=0;i<provinces.size();i++) {
				// 获取节点的属性的值
				String name = provinces.get(i).attribute("name").getValue();
				sb.append(name);
				if(i < provinces.size() - 1){
					sb.append(",");
				}
			}
			// 返回的是字符串 北京,天津,河北
			System.out.println(sb.toString());
			// 向客户端做出响应
			response.getWriter().write(sb.toString());
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

}
