package com.it.mapper;
// 페이징 
import java.util.*;

import org.apache.ibatis.annotations.Select;

import com.it.vo.FoodVO;
import com.it.vo.SeoulVO;
public interface SeoulMapper {
   // 페이징후 데이터 가지고 오기
   @Select("SELECT * FROM seoul_location "
		  +"ORDER BY no ASC "
		  +"LIMIT #{start} , 12")
   public List<SeoulVO> locationListData(int start);
   // 총페이지 
   @Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_location")
   public int locationTotalPage();
   
   // 상세보기 
   @Select("SELECT * FROM seoul_location "
		  +"WHERE no=#{no}")
   public SeoulVO locationDetailData(int no);
   
   
   @Select("SELECT * FROM seoul_nature "
			  +"WHERE no=#{no}")
   public SeoulVO natureDetailData(int no);
   
   @Select("SELECT * FROM seoul_nature "
			  +"ORDER BY no ASC "
			  +"LIMIT #{start} , 12")
	public List<SeoulVO> natureListData(int start);
	// 총페이지 
	@Select("SELECT CEIL(COUNT(*)/12.0) FROM seoul_nature")
	public int natureTotalPage();
   
	@Select("SELECT no,poster,name FROM food_house "
		   +"WHERE address LIKE CONCAT('%',#{name},'%')")
	public List<FoodVO> foodLikeData(String name);
}






