package org.smart.dao;

import java.sql.Connection;

import org.smart.bean.GuestBook;

public class OracleGuestBookDAO implements IDAO{

	@Override
	public Connection connect() {
		return null;
	}

	@Override
	public int write(Connection con, GuestBook book) {
		return 0;
	}

	@Override
	public GuestBook[] readBook(Connection con) {
		return null;
	}

	@Override
	public void disconnect(Connection con) {
		
	}
	
}
