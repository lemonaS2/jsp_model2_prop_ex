package org.smart.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import org.smart.bean.GuestBook;

public class MySQLGuestBookDAO implements IDAO, MySQLConstant{
	private static MySQLGuestBookDAO instance = new MySQLGuestBookDAO();

	private MySQLGuestBookDAO(){
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
	}

	
	public static MySQLGuestBookDAO getInstance(){
		return instance;
	}
	
	@Override
	public Connection connect() {
		Connection con = null;
		
		try {
			con = DriverManager.getConnection(DB_URL, UID, UPW);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return con;
	}

	@Override
	public int write(Connection con, GuestBook book) {
		int result = 0;
		PreparedStatement pStmt = null;
		
		try {
			pStmt = con.prepareStatement(WRITE);
			pStmt.setString(1, book.getContent());
			pStmt.setString(2, book.getReg());
			
			result = pStmt.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(pStmt);
		}
		
		return result;
	}

	@Override
	public GuestBook[] readBook(Connection con) {
		GuestBook[] books = null;
		
		PreparedStatement pStmt = null;
		ResultSet rs = null;
		
		try {
			pStmt = con.prepareStatement(READ_BOOK);
			rs = pStmt.executeQuery();
			
			Vector<GuestBook> vector = new Vector<GuestBook>();
			
			while(rs.next()){
				GuestBook book = new GuestBook(
					rs.getString("gid"),
					rs.getString("content"),
					rs.getString("reg")
				);
				vector.add(book);
			}
			books = vector.toArray(new GuestBook[0]);
		} catch (Exception e) {
			e.printStackTrace();
		} finally{
			closeAll(rs);
			closeAll(pStmt);
		}
		
		return books;
	}

	@Override
	public void disconnect(Connection con) {
			try {
				if(con != null)con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	private void closeAll(PreparedStatement pStmt){
			try {
				if(pStmt != null)pStmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	private void closeAll(ResultSet rs){
			try {
				if(rs != null)rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
	}
	
	
}
