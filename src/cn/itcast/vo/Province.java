package cn.itcast.vo;

import java.util.ArrayList;
import java.util.List;

public class Province {
	
	/**
	 * XStream��JavaBeanת����xml���ַ������ͣ�
	 */
	private String name;
	// һ��ʡ�����ж������
	private List<City> citys = new ArrayList<City>();
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<City> getCitys() {
		return citys;
	}
	public void setCitys(List<City> citys) {
		this.citys = citys;
	}
	
	// �ṩ�˷���
	public void addCity(City c){
		citys.add(c);
	}
}
