package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.it.dao.*;
@Controller
public class SeoulLocationController {
   @Autowired
   private SeoulDAO dao;
   
   // 화면 출력 => Get
   @GetMapping("location/location.do")
   public String seoul_location(String page, Model model)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int start=(curpage*9)-9;
	   List<SeoulVO> list=dao.locationData(start);
	   model.addAttribute("list", list);
	   return "location/location";
   }
   // 데이터 받아서 처리 => POST
}









