package com.it.dao;
import java.util.*;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
public interface DataBoardMapper {
   @Select("SELECT no,subject,name,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,hit "
		  +"FROM databoard "
		  +"ORDER BY no DESC "
		  +"LIMIT #{start},10") // 페이지 나누기 
   public List<DataBoardVO> databoardListData(int start);
   
   // 총페이지 
   @Select("SELECT CEIL(COUNT(*)/10.0) FROM databoard")
   public int databoardTotalPage();
   
   // 데이터 추가 
   @Insert("INSERT INTO databoard(name,subject,content,pwd,filename,filesize,filecount) "
		  +"VALUES(#{name},#{subject},#{content},#{pwd},"
		  +"#{filename},#{filesize},#{filecount})")
   // #{name}=> vo.getName()
   public void databoardInsert(DataBoardVO vo);
   
   // 상세보기 
   // 1. 조회수 증가 
   @Update("UPDATE databoard SET "
		  +"hit=hit+1 "
		  +"WHERE no=#{no}")
   public void databoardHitIncrement(int no);
   // 매개변수는 한개만 지정이 가능 
   // 입력해야 할 데이터가 많은 경우 : VO(vo안에 있는 변수) , Map(vo에 없는 변수 사용시에)
   // 예) => 검색어 , 페이지 
   // 2. 실제 상세볼 데이터 읽기
   @Select("SELECT no,name,subject,content,DATE_FORMAT(regdate,'%Y-%m-%d') as dbday,"
		  +"hit,filename,filesize,filecount "
		  +"FROM databoard "
		  +"WHERE no=#{no}")
   public DataBoardVO databoardDetailData(int no);
   // 메소드 ==> 매개변수(사용자가 보낸값) , 리턴형(결과값)
}













