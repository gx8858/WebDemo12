package cn.itcast.vo;

public class City {
	
	/**
	 * XStream把JavaBean转换成xml（字符串类型）
	 */
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public City() {
		super();
	}

	public City(String name) {
		super();
		this.name = name;
	}

}
