package com.it.board.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

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
	   //int start=(curpage*10)-10;// 페이지의 시작 위치 
	   Map map=new HashMap();
	   map.put("start", (curpage*10)-10);
	   map.put("end",10);
	   // 데이터베이스에 값을 얻어 온다 
	   List<BoardVO> list=service.boardListData(map);
	   for(BoardVO vo:list)
	   {
		   System.out.println(vo.getDbday()+","+vo.getName());
	   }
	   int totalpage=service.boardTotalPage();
	   // JSP에 출력할 데이터 전송 : Model(전송객체)
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   model.addAttribute("list", list);
	   //model.addAttribute("msg", "Hello Spring-Boot");
	   
	   return "list";
   }
   @GetMapping("/detail")
   public String board_detail(int no,Model model)
   {
	   BoardVO vo=service.boardDetailData(no);
	   model.addAttribute("vo", vo);
	   return "detail";
   }
   @GetMapping("/insert")
   public String board_insert()
   {
	   return "insert"; // /WEB-INF/jsp/insert.jsp
   }
   @PostMapping("/insert_ok") //Ajax,<form>
   public String board_insert_ok(BoardVO vo)
   {
	   service.boardInsert(vo);
	   return "redirect:/";// 목록으로 간다
   }
   
   @GetMapping("/delete")
   public String boardDelete(int no)
   {
	   service.boardDelete(no);
	   return "redirect:/";
   }
   
}










