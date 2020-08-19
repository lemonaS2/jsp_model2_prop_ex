package org.smart.dao;

public interface MySQLConstant {
	String DRIVER = "com.mysql.jdbc.Driver";
	
	String DB_URL = "jdbc:mysql://localhost:3306/test";
	String UID = "root";
	String UPW = "1234";
	
	String WRITE = "INSERT INTO guest_book (content, reg) " +
			"VALUES(?,?)";
	String READ_BOOK =
			"SELECT * FROM guest_book ORDER BY gid DESC";
}
