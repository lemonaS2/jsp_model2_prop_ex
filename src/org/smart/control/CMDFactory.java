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
			// cmdsInfo.properties�� Ű�� *.do �� ������
			// ? <- �ƹ����̳� �� ���� �� �ִ�.
			Set<?> keys = prop.keySet();
			// ObjectŸ�� = ?���, 
			for (Object keyObj : keys) {
				// 
				String key = keyObj.toString();
				// Ű �� ���� value�� ������ (org.smart.cmd.ReadCmd)
				String className = prop.getProperty(key);
				// org.smart.cmd.ReadCmd �о Ŭ������ ������ �о��
				// newInstance() -> �ش� Ŭ����(�ҷ��� className)�� ��ü�� ���� �� ���ִ�.
				// (new className)�� ���� �ǹ� (class�̸��� ���ڿ��̶� new�δ� �� ���� ����.)
				// �̷��� ������ ObjectŸ������ �Ѿ�ͼ� ICMD�� �޴´�.
				// ������ : ���÷��Ǹ� �ϸ� private�� �� ���ٵǾ ��ü������ ������ �ı� �� ���� �ִ�.
				// private ����� class��.setAccessible(true)�� �ϸ� ��밡��
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
