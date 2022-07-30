package com.it.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.*;
import com.it.board.dao.*;
import com.it.board.entity.*;
@Controller
public class BoardController {
    @Autowired
    private BoardDAO dao;
    
    @GetMapping("/")
    public String board_list(String page,Model model)
    {
    	if(page==null)
    		page="1";
    	int curpage=Integer.parseInt(page);
    	int start=(curpage*10)-10;
    	List<BoardEntity> list=dao.boardListData(start);
    	int totalpage=dao.boardTotalPage();
    	
    	model.addAttribute("list", list);
    	model.addAttribute("curpage", curpage);
    	model.addAttribute("totalpage", totalpage);
    	
    	return "list";
    }
    
    @GetMapping("/detail")
    public String board_detail(int no,Model model)
    {
    	BoardEntity vo=dao.findByNo(no);
    	vo.setHit(vo.getHit()+1);
    	dao.save(vo);
    	vo=dao.findByNo(no);
    	model.addAttribute("vo", vo);
    	return "detail";
    }
    @GetMapping("/insert")
    public String board_insert()
    {
    	return "insert";
    }
    @PostMapping("/insert_ok")
    public String board_insert_ok(BoardEntity vo)
    {
    	dao.save(vo);
    	return "redirect:/";
    }
    @GetMapping("/delete")
    public String board_delete(int no)
    {
    	BoardEntity vo=dao.findByNo(no);
    	dao.delete(vo);
    	return "redirect:/";
    }
    @GetMapping("/update")
    public String board_update(int no, Model model)
    {
    	BoardEntity vo=dao.findByNo(no);
    	model.addAttribute("vo", vo);
    	return "update";
    }
    @PostMapping("/update_ok")
    public String board_update_ok(BoardEntity vo,RedirectAttributes ra)
    {
    	/*
    	 *  전송 (화면 이동) 
    	 *    forward() ======> 화면 이동 (request를 전송) ==> Model
    	 *      return "jsp파일명";
    	 *    sendRedirect() ==> 이미 만들어지 화면으로 이동(request가 초기화) ==> RedirectAttributes
    	 *      return "redirect:/"
    	 */
    	dao.save(vo);// 수정 
    	ra.addAttribute("no", vo.getNo());
    	return "redirect:/detail";
    }
    
}











