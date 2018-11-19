package cn.itcast.json;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.junit.Test;

import cn.itcast.vo.User;

public class JsonDemo {
	
	@Test
	public void run(){
		JSONObject json = new JSONObject();
		json.put("name", "zhangsan");
		json.put("age", 18);
		String sjosn = json.toString();
		System.out.println(sjosn);   // {"name":"zhangsan","age":18}
	}
	
	@Test
	public void run2(){
		User user = new User(10, "zhaosi", "123");
		JSONObject j = JSONObject.fromObject(user);
		System.out.println(j.toString()); // {"id":10,"password":"123","username":"zhaosi"}
	}
	
	
	@Test
	public void run3(){
		JSONArray ja = new JSONArray();
		User user = new User(10, "zhaosi", "123");
		ja.add(user);
		System.out.println(ja.toString());  // [{"id":10,"password":"123","username":"zhaosi"}]
	}
	
	@Test
	public void run4(){
		
		User user = new User(10, "zhaosi", "123");
		JSONArray ja = JSONArray.fromObject(user);
		System.out.println(ja.toString());  // [{"id":10,"password":"123","username":"zhaosi"}]
	}
	
	
}
