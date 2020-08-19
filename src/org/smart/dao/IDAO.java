package org.smart.dao;

import java.sql.Connection;

import org.smart.bean.GuestBook;

public interface IDAO {
	// DAOÀÇ ±ÔÄ¢
	Connection connect();
	int write(Connection con, GuestBook book);
	GuestBook[] readBook(Connection con);
	void disconnect(Connection con);  
}
