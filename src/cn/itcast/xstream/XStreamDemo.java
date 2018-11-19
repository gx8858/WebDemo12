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
		p.setName("北京");
		p.addCity(new City("东城区"));
		p.addCity(new City("西城区"));
		pList.add(p);
		return pList;
	}
	
	
	/**
	 <list>							--> pList
		  <cn.itcast.vo.Province>	-->相当于Province的全路径
		    <name>北京</name>		-->相当于Province类的name属性
		    <citys>					-->相当于Province类的citys属性
		      <cn.itcast.vo.City>	-->相当于City类的全路径
		        <name>东城区</name>	-->相当于City类的name属性
		      </cn.itcast.vo.City>
		      <cn.itcast.vo.City>
		        <name>西城区</name>
		      </cn.itcast.vo.City>
		    </citys>
		  </cn.itcast.vo.Province>
		</list> 
	 */
	@Test
	public void run(){
		// 装的是一个省份，北京，北京有两个区
		List<Province> pList = getPList();
		// 使用XStream方式
		XStream xs = new XStream();
		String xml = xs.toXML(pList);
		System.out.println(xml);
	}
	
	
	/**
	 <china>
	  <province>
	    <name>北京</name>
	    <citys>
	      <city>
	        <name>东城区</name>
	      </city>
	      <city>
	        <name>西城区</name>
	      </city>
	    </citys>
	  </province>
	</china>
	 */
	/**
	 * 改造
	 * list改变china
	 * cn.itcast.vo.Province改变<province>
	 * <cn.itcast.vo.City>改成<city>节点
	 */
	@Test
	public void run1(){
		// 装的是一个省份，北京，北京有两个区
		List<Province> pList = getPList();
		// 使用XStream方式
		XStream xs = new XStream();
		
		// 使用别名的方式
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		String xml = xs.toXML(pList);
		System.out.println(xml);
	}
	
	
	/**
	 * 
	<china>
	  <province name="北京">
	    <citys>
	      <city>
	        <name>东城区</name>
	      </city>
	      <city>
	        <name>西城区</name>
	      </city>
	    </citys>
	  </province>
	</china>
	 */
	/**
	 * 
	 * 想把name子节点升级成<province>的属性
	 */
	@Test
	public void run2(){
		// 装的是一个省份，北京，北京有两个区
		List<Province> pList = getPList();
		// 使用XStream方式
		XStream xs = new XStream();
		
		// 使用别名的方式
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
	  <province name="北京">
	    <city>
	      <name>东城区</name>
	    </city>
	    <city>
	      <name>西城区</name>
	    </city>
	  </province>
	</china>
	 */
	/**
	 * 
	 * 把citys的属性删除掉
	 */
	@Test
	public void run3(){
		// 装的是一个省份，北京，北京有两个区
		List<Province> pList = getPList();
		// 使用XStream方式
		XStream xs = new XStream();
		
		// 使用别名的方式
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		xs.useAttributeFor(Province.class, "name");
		// 把citys属性删除掉了
		xs.addImplicitCollection(Province.class, "citys");
		// 直接把该字符串响应到客户端上
		String xml = xs.toXML(pList);
		System.out.println(xml);
	}

	/**
	 * <china>
		  <province name="北京">
		    <city>
		      <name>东城区</name>
		    </city>
		    <city>
		      <name>西城区</name>
		    </city>
		  </province>
		</china>
	 */
	
	@Test
	public void fun5() {
		// 装的是一个省份，北京，北京有两个区
		List<Province> pList = getPList();
		// 使用XStream方式
		XStream xs = new XStream();
		
		// 使用别名的方式
		xs.alias("china", List.class);
		xs.alias("province", Province.class);
		xs.alias("city", City.class);
		
		xs.useAttributeFor(Province.class, "name");
		// 把citys属性删除掉了
		xs.addImplicitCollection(Province.class, "citys");
		
		/*
		 * 让City类的，名为description属性不生成对应的xml元素(这里没有description)
		 */
//		xs.omitField(City.class, "description");
		// 直接把该字符串响应到客户端上
		String xml = xs.toXML(pList);
		System.out.println(xml);
		
		
	}

}
