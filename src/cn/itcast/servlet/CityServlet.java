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
 * ͨ��ʡ�ݵ���Ϣ��ȡ��ʡ�����еĳ���
 * @author Administrator
 *
 */
public class CityServlet extends HttpServlet {

	private static final long serialVersionUID = 2252740058409685815L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		/**
		 * ���ղ���
		 * 
		 */
		request.setCharacterEncoding("UTF-8");
		// ��������
		String pname = request.getParameter("pname");
		// ����china.xml�ļ���ͨ��pname����ȡ���еĳ�����Ϣ
		// ��ȡchina.xml�ĵ���������
		InputStream in = CityServlet.class.getClassLoader().getResourceAsStream("china.xml");
		SAXReader reader = new SAXReader();
		try {
			Document document = reader.read(in);
			
			// ʵ��XPATH
			// ���������ֵ���Ʊ���  �ӱ�  ����
			Node pnode = document.selectSingleNode("//province[@name='"+pname+"']");
			// ��nodeת�����ַ���
			String text = pnode.asXML();
			
			System.out.println(text);
			
			// ����Ӧ����ʲô����
			response.setContentType("text/xml;charset=UTF-8");
			// ��ҳ����Ӧ
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
