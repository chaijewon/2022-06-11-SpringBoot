package com.it.model;

import javax.servlet.http.HttpServletRequest;
import java.util.*;
import com.it.dao.*;
public class ListModel implements Model{

	@Override
	public String execute(HttpServletRequest request) {
		//1. page를 받는다 
		String page=request.getParameter("page");
		if(page==null)
			page="1"; // 시작 => 페이지 선택이 안됨 => 디폴트 페이지 
		int curpage=Integer.parseInt(page);// 현재 페이지
		int start=(curpage*10)-10;  // 0  LIMIT 시작 , 갯수 
		List<BoardVO> list=BoardDAO.boardListData(start);
		int totalpage=BoardDAO.boardTotalPage();
		// 데이터를 JSP로 전송 
		request.setAttribute("list", list);
		request.setAttribute("curpage", curpage);
		request.setAttribute("totalpage", totalpage);
		return "board/list.jsp";
	}

}
