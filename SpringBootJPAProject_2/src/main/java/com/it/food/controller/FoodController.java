package com.it.food.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.*;
import com.it.food.dao.*;
import com.it.food.entity.*;
@Controller
public class FoodController {
    @Autowired // 이미 메모리 할당된 주소값을 자동으로 받는다 
    private FoodDAO dao;
    
    @GetMapping("/list")
    public String food_list(Model model)
    {
    	// Model => 전송 
    	List<FoodEntity> list=dao.findAll();
    	model.addAttribute("list", list);
    	return "food/list";
    }
}
