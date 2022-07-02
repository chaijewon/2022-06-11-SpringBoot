package com.it.model;

import javax.servlet.http.HttpServletRequest;

public class UpdateModel implements Model{

	@Override
	public String execute(HttpServletRequest request) {
		String msg="UpdateModel 연결";
		request.setAttribute("msg", msg);
		return "board/update.jsp";
	}

}