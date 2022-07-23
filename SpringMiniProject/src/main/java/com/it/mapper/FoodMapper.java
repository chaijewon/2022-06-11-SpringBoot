package com.it.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.it.vo.CategoryVO;
public interface FoodMapper {
  @Select("SELECT cno,title,poster,subject "
		 +"FROM food_category")
  public List<CategoryVO> categroyListData();// 자동 구현 => JPA (SQL문장도 제작한다)
}
