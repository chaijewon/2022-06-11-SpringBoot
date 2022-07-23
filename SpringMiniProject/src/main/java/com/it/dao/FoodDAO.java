package com.it.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.vo.*;
import com.it.mapper.*;
// 스프링에서 관리 
@Repository
/*
 *   component-scan => package지정 ==> 클래스중에 선별적으로 메모리를 요청 (관리)
 *   => @Component
 *      @Repository
 *      @Service
 *      @Controller
 *      @RestController
 *      @ControllerAdvice ==> 메모리할당 (관리)
 *      
 *      VO,Mapper => 메모리 할당을 하지 않는다 (프로그래머가 직접 관리)
 */
public class FoodDAO {
    // 구현된 Mapper를 스프링에 요청 
	@Autowired  // 구현된 클래스의 메모리 주소를 주입 (자동 주입)
	private FoodMapper mapper;
	
	public List<CategoryVO> categroyListData()
	{
		return mapper.categroyListData();
	}
	
	public List<FoodVO> foodCategoryListData(int cno)
	{
		return mapper.foodCategoryListData(cno);
	}
	public CategoryVO categoryInfoData(int cno)
	{
		return mapper.categoryInfoData(cno);
	}
	public FoodVO foodDetailData(int no)
	{
		return mapper.foodDetailData(no);
	}
}









