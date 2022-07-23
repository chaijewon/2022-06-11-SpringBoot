package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;

import javax.servlet.http.HttpSession;

import com.it.vo.*;
import com.it.dao.*;
@Controller //Model(자바로 요청처리하는 클래스 ==> HandlerMapping에서 클래스 찾기가 가능)
public class MainController {
   // 구분 => 찾아서 수행 ==> @RequestMapping(사용자가 전송한 URI) => @GetMapping , @PostMapping
   @Autowired
   private FoodDAO dao;
   @RequestMapping("main/main.do") 
   public String main_page(Model model)
   {
	   // include에 포함할 jsp전송 
	   // 스프링 => 데이터를 전송하는 객체 Model (request를 포함 => DispatcherServlet)
	   // ==> 메소드의 매개변수로 전송 
	   // 필요한 객체 , 요청값을 받을 경우 <====> DispatcherServlet <==> 매개변수
	   List<CategoryVO> list=dao.categroyListData();
	   //home.jsp로 List => 받아서 출력 
	   model.addAttribute("list", list);
	   model.addAttribute("main_jsp", "../main/home.jsp");
	   return "main/main";
   }
   
   @RequestMapping("member/login.do")
   // 매개변수 ==> DispatcherServlet에 의해서 호출시에 데이터값을 매개변수로 주입 
   public String member_login(String id,String pwd,HttpSession session,Model model)
   {
	   int count=dao.idCount(id);
	   String res="";
	   if(count==0)
	   {
		   res="NOID"; //ID가 없는 경우
	   }
	   else
	   {
	      MemberVO vo=dao.memberInfoData(id);
	      if(pwd.equals(vo.getPwd()))// 로그인 상태
	      {
	    	  res="OK";
	    	  session.setAttribute("id", id);
	    	  session.setAttribute("name", vo.getName());
	    	  session.setAttribute("admin", vo.getAdmin());
	      }
	      else // 비밀번호가 틀린 상태 
	      {
	    	  res="NOPWD";
	      }
	   }
	   model.addAttribute("res", res);
	   return "member/login";
   }
   @RequestMapping("member/logout.do")
   public String member_logout(HttpSession session)
   {
	   session.invalidate(); //session에 저장된 모든값을 지운다 
	   return "redirect:../main/main.do";
   }
}







