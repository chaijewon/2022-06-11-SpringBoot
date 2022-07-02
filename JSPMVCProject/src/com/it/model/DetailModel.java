package com.it.model;

import javax.servlet.http.HttpServletRequest;

public class DetailModel implements Model{

	@Override
	public String execute(HttpServletRequest request) {
		String msg="DetailModel 연결";
		request.setAttribute("msg", msg);
		return "board/detail.jsp";
	}

}
