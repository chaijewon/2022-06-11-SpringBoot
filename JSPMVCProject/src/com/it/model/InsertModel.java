package com.it.model;

import javax.servlet.http.HttpServletRequest;

public class InsertModel implements Model{

	@Override
	public String execute(HttpServletRequest request) {
		String msg="InsertModel 연결";
		request.setAttribute("msg", msg);
		return "board/insert.jsp";
	}

}
