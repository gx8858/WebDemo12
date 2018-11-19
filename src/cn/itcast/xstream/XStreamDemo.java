package cn.itcast.xstream;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.thoughtworks.xstream.XStream;

import cn.itcast.vo.City;
import cn.itcast.vo.Province;

public class XStreamDemo {
	
	public List<Province> getPList(){
		List<Province> pList = new ArrayList<Province>();
		Province p = new Province();
		p.setName("����");
		p.addCity(new City("������"));
		p.addCity(new City("������"));
		pList.add(p);
		return pList;
	}
	
	
	/**
	 <list>							--> pList
		  <cn.itcast.vo.Province>	-->�൱��Province��ȫ·��
		    <name>����</name>		-->�൱��Province���name����
		    <citys>					-->�൱��Province���citys����
		      <cn.itcast.vo.City>	-->�൱��City���ȫ·��
		        <name>������</name>	-->�൱��City���name����
		      </cn.itcast.vo.City>
		      <cn.itcast.vo.City>
		        <name>������</name>
		      </cn.itcast.vo.City>
		    </citys>
		  </cn.itcast.vo.Province>
		</list> 
	 */
	@Test
	public void run(){
		// װ����һ��ʡ�ݣ�������������������
		List<Province> pList = getPList();
		// ʹ��XStream��ʽ
		XStream xs = new XStream();
		String xml = xs.toXML(pList);
		System.out.println(xml);
	}
	
	
	/**
	 <china>
	  <province>
	    <name>����</name>
	    <citys>
	      <city>
	        <name>������</name>
	      </city>
	      <city>
	        <name>������</name>
	      </city>
	    </citys>
	  </province>
	</china>
	 */
	/**
	 * ����
	 * list�ı�china
	 * cn.itcast.vo.Province�ı�<province>
	 * <cn.itcast.vo.City>�ĳ�<city>�ڵ�
	 */
	@Test
	public void run1(){
		// װ����һ��ʡ�ݣ�������������������
		List<Province> pList = getPList();
		// ʹ��XStream��ʽ
		XStream xs = new XStream();
		
		// ʹ�ñ����ķ�ʽ
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		String xml = xs.toXML(pList);
		System.out.println(xml);
	}
	
	
	/**
	 * 
	<china>
	  <province name="����">
	    <citys>
	      <city>
	        <name>������</name>
	      </city>
	      <city>
	        <name>������</name>
	      </city>
	    </citys>
	  </province>
	</china>
	 */
	/**
	 * 
	 * ���name�ӽڵ�������<province>������
	 */
	@Test
	public void run2(){
		// װ����һ��ʡ�ݣ�������������������
		List<Province> pList = getPList();
		// ʹ��XStream��ʽ
		XStream xs = new XStream();
		
		// ʹ�ñ����ķ�ʽ
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		xs.useAttributeFor(Province.class, "name");
		
		String xml = xs.toXML(pList);
		System.out.println(xml);
	}
	
	
	/**
	 * 
	 <china>
	  <province name="����">
	    <city>
	      <name>������</name>
	    </city>
	    <city>
	      <name>������</name>
	    </city>
	  </province>
	</china>
	 */
	/**
	 * 
	 * ��citys������ɾ����
	 */
	@Test
	public void run3(){
		// װ����һ��ʡ�ݣ�������������������
		List<Province> pList = getPList();
		// ʹ��XStream��ʽ
		XStream xs = new XStream();
		
		// ʹ�ñ����ķ�ʽ
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		xs.useAttributeFor(Province.class, "name");
		// ��citys����ɾ������
		xs.addImplicitCollection(Province.class, "citys");
		// ֱ�ӰѸ��ַ�����Ӧ���ͻ�����
		String xml = xs.toXML(pList);
		System.out.println(xml);
	}

	/**
	 * <china>
		  <province name="����">
		    <city>
		      <name>������</name>
		    </city>
		    <city>
		      <name>������</name>
		    </city>
		  </province>
		</china>
	 */
	
	@Test
	public void fun5() {
		// װ����һ��ʡ�ݣ�������������������
		List<Province> pList = getPList();
		// ʹ��XStream��ʽ
		XStream xs = new XStream();
		
		// ʹ�ñ����ķ�ʽ
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		xs.useAttributeFor(Province.class, "name");
		// ��citys����ɾ������
		xs.addImplicitCollection(Province.class, "citys");
		
		/*
		 * ��City��ģ���Ϊdescription���Բ����ɶ�Ӧ��xmlԪ��(����û��description)
		 */
//		xs.omitField(City.class, "description");
		// ֱ�ӰѸ��ַ�����Ӧ���ͻ�����
		String xml = xs.toXML(pList);
		System.out.println(xml);
		
		
	}

}
