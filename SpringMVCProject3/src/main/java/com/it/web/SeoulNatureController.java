package com.it.web;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.it.dao.*;
import java.util.*;
@RestController
public class SeoulNatureController {
   @Autowired
   private SeoulDAO dao;
   @GetMapping(value = "nature/nature.do",produces = "text/plain;charset=UTF-8")
   public String nature_list(String page)
   {
	   if(page==null)
		   page="1";
	   int curpage=Integer.parseInt(page);
	   int start=(curpage*9)-9;
	   List<SeoulVO> list=dao.natureData(start);
	   // [{},{},{},{}...] => 자바스크립트 , 코틀린 
	   JSONArray arr=new JSONArray(); // ArrayList []
	   for(SeoulVO vo:list)
	   {
		   JSONObject obj=new JSONObject(); // VO   => {}
		   obj.put("no", vo.getNo());
		   obj.put("name", vo.getName());
		   obj.put("poster", vo.getPoster());
		   
		   arr.add(obj);
	   }
	   return arr.toJSONString();
   }
}






