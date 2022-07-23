package com.it.mapper;
import java.util.*;

import org.apache.ibatis.annotations.Select;
import com.it.vo.*;
public interface FoodMapper {
  @Select("SELECT cno,title,poster,subject "
		 +"FROM food_category")
  public List<CategoryVO> categroyListData();// 자동 구현 => JPA (SQL문장도 제작한다)
  /*
   *  <select id="categroyListData" resultType="CategoryVO">
   */
  
  // 카테고리별 맛집 목록 
  @Select("SELECT no,name,tel,type,address,poster,score "
		 +"FROM food_house "
		 +"WHERE cno=#{cno}")
  public List<FoodVO> foodCategoryListData(int cno);
  /*
   *   <select id="foodCategoryListData" resultType="FoodVO" parameterType="int">
   */
  // 매개변수는 반드시 1개만 설정이 가능 ===> 여러개가 필요한 경우 (~VO,Map)
  
  @Select("SELECT title,subject "
		 +"FROM food_category "
		 +"WHERE cno=#{cno}")
  public CategoryVO categoryInfoData(int cno);
  
  // 상세보기 
  @Select("SELECT * FROM food_house "
		 +"WHERE no=#{no}")
  public FoodVO foodDetailData(int no);
  
  //로그인 처리 
  @Select("SELECT COUNT(*) FROM member "
		 +"WHERE id=#{id}")
  // ID존재여부 확인 
  public int idCount(String id);
  
  @Select("SELECT pwd,name,admin FROM member "
		 +"WHERE id=#{id}")
  public MemberVO memberInfoData(String id);
  
 
}









