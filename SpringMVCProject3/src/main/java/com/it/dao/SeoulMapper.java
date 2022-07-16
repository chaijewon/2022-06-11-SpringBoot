package com.it.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface SeoulMapper {
   // 명소읽기 
   @Select("SELECT no,poster,name "
		  +"FROM seoul_location "
		  +"ORDER BY no ASC "
		  +"LIMIT #{start},9")
   public List<SeoulVO> locationData(int start);
   
   @Select("SELECT no,poster,name "
			  +"FROM seoul_location "
			  +"ORDER BY no ASC "
			  +"LIMIT #{start},9")
   public List<SeoulVO> natureData(int start);
}
