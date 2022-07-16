package com.it.model;

import javax.servlet.http.HttpServletRequest;

import com.it.controller.RequestMapping;
// 메모리
public class BoardController {
   // 1. 목록 
   @RequestMapping("list.do")
   public String board_list(HttpServletRequest request)
   {
	    String msg="게시판 목록";
	    request.setAttribute("msg", msg);
	    return "list";
   }
   // 2. 상세보기 
   @RequestMapping("detail.do")
   public String board_detail(HttpServletRequest request)
   {
	   String msg="게시판 상세보기";
	   request.setAttribute("msg", msg);
	   return "detail";
   }
   // 3. 데이터 추가 
   @RequestMapping("insert.do")
   public String board_insert(HttpServletRequest request)
   {
	   String msg="게시판 추가";
	   request.setAttribute("msg", msg);
	   return "insert";
   }
}
