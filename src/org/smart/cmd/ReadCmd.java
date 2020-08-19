package org.smart.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.smart.bean.GuestBook;
import org.smart.dao.DAOFactory;
import org.smart.dao.IDAO;

public class ReadCmd implements ICMD{

	@Override
	public String action(HttpServletRequest request) {
		// dao가 Oracle일수도 있고 MySQL일수도 있다.
		
		IDAO dao = DAOFactory.getDao();
		Connection con = dao.connect();
		GuestBook[] books = dao.readBook(con);
		dao.disconnect(con);
		request.setAttribute("books", books);
		
		return "main.jsp";
	}
	
}
