package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

// 요청 처리 => JSP로 결과값 전송 
/*
 *   JSP 
 *   <%
 *       소스 => 자바로 이동 
 *   %>
 */
import java.util.*;
import com.it.vo.*;
import com.it.dao.*;
@Controller
public class SeoulController {
   // 필요한 객체를 스프링으로부터 얻어 온다  (SeoulDAO)
   @Autowired
   private SeoulDAO dao;
   
   // 사용자 요청 => @RequestMapping()
   @RequestMapping("seoul/seoul_location.do")
   public String seoul_location(String page,Model model)
   {
	   if(page==null)
		   page="1";//디폴트 페이지 지정 
	   int curpage=Integer.parseInt(page); // 현재 보고 있는 페이지
	   int start=(curpage*12)-12;//0번부터 시작 
	   List<SeoulVO> list=dao.locationListData(start);
	   int totalpage=dao.locationTotalPage();
	   
	   // 블록 처리 
	   final int BLOCK=5;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   // 1 6 11 16 ....
	   // startPage = 1 ==> curpage=1,2,3,4,5
	   // 
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   // 데이터를 보내준다 
	   model.addAttribute("list",list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("main_jsp", "../seoul/location.jsp");
	   return "main/main"; // 사이트를 출력 
   }
   
   @RequestMapping("seoul/seoul_nature.do")
   public String seoul_nature(String page,Model model)
   {
	   if(page==null)
		   page="1";//디폴트 페이지 지정 
	   int curpage=Integer.parseInt(page); // 현재 보고 있는 페이지
	   int start=(curpage*12)-12;//0번부터 시작 
	   List<SeoulVO> list=dao.natureListData(start);
	   int totalpage=dao.natureTotalPage();
	   
	   // 블록 처리 
	   final int BLOCK=5;
	   int startPage=((curpage-1)/BLOCK*BLOCK)+1;
	   // 1 6 11 16 ....
	   // startPage = 1 ==> curpage=1,2,3,4,5
	   // 
	   int endPage=((curpage-1)/BLOCK*BLOCK)+BLOCK;
	   if(endPage>totalpage)
		   endPage=totalpage;
	   
	   // 데이터를 보내준다 
	   model.addAttribute("list",list);
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("startPage", startPage);
	   model.addAttribute("endPage", endPage);
	   model.addAttribute("main_jsp", "../seoul/nature.jsp");
	   return "main/main"; // 사이트를 출력 
   }
   
   @RequestMapping("seoul/location_detail.do")
   public String location_detail(int no,Model model)
   {
	   SeoulVO vo=dao.locationDetailData(no);
	   String address=vo.getAddress();
	   address=address.substring(address.indexOf(" ")+1);
	   vo.setAddress(address);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../seoul/location_detail.jsp");
	   return "main/main";
   }
   
   @RequestMapping("seoul/nature_detail.do")
   public String nature_detail(int no,Model model)
   {
	   SeoulVO vo=dao.natureDetailData(no);
	   String address=vo.getAddress();
	   address=address.substring(address.indexOf(" ")+1);
	   vo.setAddress(address);
	   model.addAttribute("vo", vo);
	   model.addAttribute("main_jsp", "../seoul/nature_detail.jsp");
	   return "main/main";
   }
   
}










