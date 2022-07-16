package com.it.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository // 메모리 할당 
public class SeoulDAO {
	   @Autowired
	   private SeoulMapper mapper;// getBean()
	        /*
	         @Select("SELECT no,poster,name "
			  +"FROM seoul_location "
			  +"ORDER BY no ASC "
			  +"LIMIT #{start},9")
			  */
	   public List<SeoulVO> locationData(int start)
	   {
		   return mapper.locationData(start);
	   }
	   
	   /* @Select("SELECT no,poster,name "
				  +"FROM seoul_location "
				  +"ORDER BY no ASC "
				  +"LIMIT #{start},9")
	    */
	   public List<SeoulVO> natureData(int start)
	   {
		   return mapper.natureData(start);
	   }
}
