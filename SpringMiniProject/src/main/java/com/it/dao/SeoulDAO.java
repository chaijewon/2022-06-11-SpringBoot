package com.it.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.it.mapper.SeoulMapper;
import com.it.vo.*;
// 메모리 할당 => 스프링에서 관리 ==> (클래스 관리 => 클래스(컴포넌트) , 컨테이너) 
/*
 *   WebApplicationContext <===> DispatcherServlet
 *                         HandlerMapping
 */
@Repository  
/*
 *   구분 : 선택적 메모리 할당 
 *     @Component
 *        |
 *   ------------------------------------------
 *   |              |         |               |
 *  @Repository   @Service   @Controller    @ControllerAdvice 
 *                           @RestController => Vue,Ajax,React
 */
public class SeoulDAO {
   @Autowired //DI => 자동 주입 
   private SeoulMapper mapper; //MyBatis에서 자동으로 구현 
   
   public List<SeoulVO> locationListData(int start)
   {
	   return mapper.locationListData(start);
   }
   public int locationTotalPage()
   {
	   return mapper.locationTotalPage();
   }
   public List<SeoulVO> natureListData(int start)
   {
	   return mapper.natureListData(start);
   }
   public int natureTotalPage()
   {
	   return mapper.natureTotalPage();
   }
   
   public SeoulVO locationDetailData(int no)
   {
	   return mapper.locationDetailData(no);
   }
   public SeoulVO natureDetailData(int no)
   {
	   return mapper.natureDetailData(no);
   }
}









