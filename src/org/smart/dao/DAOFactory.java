package org.smart.dao;

import java.util.Hashtable;

public class DAOFactory {
	private static Hashtable<String, IDAO> daos = 
			new Hashtable<String, IDAO>();
	
	private static String dbms;
	
	// mysql, oracle ����
	// dao�� �ٲ� ���õ� cmd���� �ٲ� �ʿ䰡 ����.
	// ���� : �� �� ���� ���õǵ� �տ� cmdŬ�������� �ٲ�� �ȵȴ�.
	public static void initDaos(String inputDbms){
		dbms = inputDbms;
		daos.put("mysql", MySQLGuestBookDAO.getInstance());
		daos.put("oracle", new OracleGuestBookDAO());
	}
	
	public static IDAO getDao(){
		return daos.get(dbms);
	}
}
