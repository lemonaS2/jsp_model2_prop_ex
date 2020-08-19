package org.smart.control;

import java.util.Hashtable;
import java.util.Properties;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.smart.cmd.ICMD;import com.sun.xml.internal.ws.resources.HttpserverMessages;

public class CMDFactory {
	private static Hashtable<String, ICMD> cmds = new Hashtable<String, ICMD>();
	
	public static void initCmds(Properties prop) {
		try {
			// cmdsInfo.properties의 키값 *.do 를 가져옴
			// ? <- 아무값이나 다 받을 수 있다.
			Set<?> keys = prop.keySet();
			// Object타입 = ?사용, 
			for (Object keyObj : keys) {
				// 
				String key = keyObj.toString();
				// 키 값 에서 value값 가져옴 (org.smart.cmd.ReadCmd)
				String className = prop.getProperty(key);
				// org.smart.cmd.ReadCmd 읽어서 클래스의 정보를 읽어옴
				// newInstance() -> 해당 클래스(불러온 className)의 객체를 생성 할 수있다.
				// (new className)과 같은 의미 (class이름이 문자열이라 new로는 할 수가 없다.)
				// 이렇게 생성시 Object타입으로 넘어와서 ICMD로 받는다.
				// 문제점 : 리플렉션를 하면 private도 다 접근되어서 객체지향의 본질을 파괴 할 수도 있다.
				// private 사용이 class명.setAccessible(true)를 하면 사용가능
				ICMD cmdObj = (ICMD)Class.forName(className).newInstance();
				cmds.put(key, cmdObj);
			} 
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace(); 
		} catch (ClassNotFoundException e) { 
			e.printStackTrace();
		}
	}
	 
	public static String doAction(HttpServletRequest request, String key){
		return cmds.get(key).action(request);
	}
}
