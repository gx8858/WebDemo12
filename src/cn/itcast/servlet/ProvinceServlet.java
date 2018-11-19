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
 * ��ȡ���е�ʡ�ݵ���Ϣ
 * @author Administrator
 *
 */
public class ProvinceServlet extends HttpServlet {
	
	private static final long serialVersionUID = -252171226830148479L;

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		// �������ĵ����루��Ӧ��
		response.setContentType("text/html;charset=UTF-8");
		// ʹ��DOM4J�Ľ���XML�ļ�
		SAXReader reader = new SAXReader();
		// ��ȡchina.xml�ĵ���������
		InputStream in = ProvinceServlet.class.getClassLoader().getResourceAsStream("china.xml");
		// ����XML�ĵ�����ȡDocument����
		try {
			/**
			 <china>
				<province name="����">
					<city>������</city>
					<city>������</city>
				</province>
				<province name="���">
					<city>��ƽ��</city>
					<city>�Ӷ���</city>
				</province>
			<china>
			 * 
			 */
			Document document = reader.read(in);
			// ��ȡ���е�ʡ�ݵ���Ϣ
			// �Ȼ�ȡ���ڵ�
			Element root = document.getRootElement();
			// ��ȡprovince�Ľڵ�
			List<Element> provinces = root.elements("province");
			StringBuffer sb = new StringBuffer();
			// ѭ������
			for (int i=0;i<provinces.size();i++) {
				// ��ȡ�ڵ�����Ե�ֵ
				String name = provinces.get(i).attribute("name").getValue();
				sb.append(name);
				if(i < provinces.size() - 1){
					sb.append(",");
				}
			}
			// ���ص����ַ��� ����,���,�ӱ�
			System.out.println(sb.toString());
			// ��ͻ���������Ӧ
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
