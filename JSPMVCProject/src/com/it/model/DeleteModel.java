package com.it.model;

import javax.servlet.http.HttpServletRequest;

public class DeleteModel implements Model{

	@Override
	public String execute(HttpServletRequest request) {
		// TODO Auto-generated method stub
		String msg="DeleteModel 연결";
		request.setAttribute("msg", msg);
		return "board/delete.jsp";
	}

}
