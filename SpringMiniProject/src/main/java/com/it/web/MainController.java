package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.*;
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
}
