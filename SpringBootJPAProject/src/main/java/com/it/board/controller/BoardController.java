package com.it.board.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}











