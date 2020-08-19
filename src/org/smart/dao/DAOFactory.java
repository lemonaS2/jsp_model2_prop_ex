package org.smart.dao;

import java.util.Hashtable;

public class DAOFactory {
	private static Hashtable<String, IDAO> daos = 
			new Hashtable<String, IDAO>();
	
	private static String dbms;
	
	// mysql, oracle 선택
	// dao가 바뀌어도 관련된 cmd들을 바꿀 필요가 없다.
	// 목적 : 둘 중 뭐가 선택되든 앞에 cmd클래스들이 바뀌면 안된다.
	public static void initDaos(String inputDbms){
		dbms = inputDbms;
		daos.put("mysql", MySQLGuestBookDAO.getInstance());
		daos.put("oracle", new OracleGuestBookDAO());
	}
	
	public static IDAO getDao(){
		return daos.get(dbms);
	}
}
