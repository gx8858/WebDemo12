package cn.itcast.vo;

import java.util.ArrayList;
import java.util.List;

public class Province {
	
	private String name;
	// 一个省份下有多个城市
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
	
	// 提供了方法
	public void addCity(City c){
		citys.add(c);
	}
}
