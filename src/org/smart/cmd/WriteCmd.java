package org.smart.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.smart.bean.GuestBook;
import org.smart.dao.DAOFactory;
import org.smart.dao.IDAO;

public class WriteCmd implements ICMD{
	
	
	// 리턴타입이 void에서 String으로 바뀜(돌아 갈 경로)
	@Override
	public String action(HttpServletRequest request) {
		
		String content = request.getParameter("content");
		GuestBook book = new GuestBook(content);
		
		IDAO dao = DAOFactory.getDao();
		Connection con = dao.connect(); 
		dao.write(con, book);
		dao.disconnect(con);
		request.setAttribute("isRedirect", true);
		
		return request.getContextPath();
	}

}
