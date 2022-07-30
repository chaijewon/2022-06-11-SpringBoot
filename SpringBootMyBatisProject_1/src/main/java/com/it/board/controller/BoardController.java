package com.it.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.it.board.service.*;
import com.it.board.vo.*;

@Controller
public class BoardController {
   @Autowired
   private BoardService service;
   
   @GetMapping("/")
   public String board_list(String page,Model model)
   {
	   if(page==null)
		   page="1"; // default page
	   int curpage=Integer.parseInt(page);
	   int start=(curpage*10)-10;// 페이지의 시작 위치 
	   // 데이터베이스에 값을 얻어 온다 
	   List<BoardVO> list=service.boardListData(start);
	   int totalpage=service.boardTotalPage();
	   // JSP에 출력할 데이터 전송 : Model(전송객체)
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   
	   return "list";
   }
}










