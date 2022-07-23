package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;
import com.it.vo.*;
import com.it.dao.*;
@Controller 
public class FoodController {
    // 데이터베이스에 등록된 데이터 읽기 ===> DAO
	// DAO객체를 가지고 온다 (스프링)
	@Autowired //주소값을 주입 
	private FoodDAO dao;
	
	// 구분해서 수행 
	@RequestMapping("food/category_list.do")
	public String food_category_list(int cno,Model model)
	{
		List<FoodVO> list=dao.foodCategoryListData(cno);
		for(FoodVO vo:list)
		{
			String poster=vo.getPoster();
			poster=poster.substring(0,poster.indexOf("^"));
			vo.setPoster(poster);
			
			String address=vo.getAddress();
			address=address.substring(0,address.indexOf("지"));
			vo.setAddress(address);
		}
		CategoryVO vo=dao.categoryInfoData(cno);
		
		// 전송 
		model.addAttribute("list", list);
		model.addAttribute("vo", vo);
		model.addAttribute("main_jsp", "../food/category_list.jsp");
		// include => request를 공유 
		return "main/main";
	}
	
}




