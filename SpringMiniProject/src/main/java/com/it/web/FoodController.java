package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
	
	// login => ajax 
	@RequestMapping("food/food_detail_before.do")
	public String food_detail_before(int no,HttpServletResponse response)
	{
		// response => 전송 (HTML , Cookie전송)
		Cookie cookie=new Cookie("food"+no, String.valueOf(no));
		// 쿠키 생성 ==> 키,값(문자열) => String.vlaueOf() => 모든 데이터형을 문자열로 변경 메소드 
		// 2. 기간 (저장)
		cookie.setMaxAge(60*60*24); // 24시간 저장 
		// 3. 저장 위치 
		cookie.setPath("/");
		// 4. response를 이용해서 전송
		response.addCookie(cookie);
		
		return "redirect:../food/food_detail.do"; //food_detail.jsp로 이동 
		/*
		 *   자바(스프링에서) 다른 JSP로 이동 
		 *   sendRedirect() => .do 재호출 
		 *   forward() => request를 전송 
		 */
	}
	
}




