package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import java.util.*;
import com.it.dao.*;
// 요청 처리 => 요청을 받아서 처리 => 결과값을 request,session => HandlerMapping
// 메모리 할당 
@Controller
public class DataBoardController {
   // DAO의 주소를 읽어 온다 
   @Autowired
   private DataBoardDAO dao;
   
   // 메소드 ==> 모든 단일 데이터는 해당 데이터형이 필요하다 ==> String으로 받을 수 있다 
   // int page ==> Integer.parseInt(null)
   public String databoard_list(String page,Model model)
   {
	   // request에 값을 모아서 전송 => 데이터를 JSP로 전송하는 객체 => Model(전송 객체)
	   if(page==null)
		   page="1"; // 디폴트 
	   
	   int curpage=Integer.parseInt(page); // 현재 페이지 
	   int start=(curpage*10)-10;
	   List<DataBoardVO> list=dao.databoardListData(start);
	   model.addAttribute("list", list);// model=request 대신 사용 
	   /*
	    *   class Model 
	    *   {
	    *      HttpServletRequest request;
	    *      public void addAttribute(String key,Object obj)
	    *      {
	    *          request.setAttribute(key,obj);
	    *      }
	    *   }
	    */
	   // 페이지 나누기 => 총페이지 
	   int totalpage=dao.databoardTotalPage();
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "databoard/list";
   }
}






