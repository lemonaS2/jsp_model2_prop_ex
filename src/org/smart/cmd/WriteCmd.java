package org.smart.cmd;

import java.sql.Connection;

import javax.servlet.http.HttpServletRequest;

import org.smart.bean.GuestBook;
import org.smart.dao.DAOFactory;
import org.smart.dao.IDAO;

public class WriteCmd implements ICMD{
	
	
	// ����Ÿ���� void���� String���� �ٲ�(���� �� ���)
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
