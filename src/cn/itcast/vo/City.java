package cn.itcast.vo;

public class City {
	
	/**
	 * XStream��JavaBeanת����xml���ַ������ͣ�
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
