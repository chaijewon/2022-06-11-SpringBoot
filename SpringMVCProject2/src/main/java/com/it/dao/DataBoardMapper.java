package com.it.dao;
import java.util.*;

import org.apache.ibatis.annotations.Select;
public interface DataBoardMapper {
   @Select("SELECT no,subject,name,DATE_FROMAT(regdate,'%Y-%m-%d') as dbday,hit "
		  +"FROM databoard "
		  +"ORDER BY no DESC "
		  +"LIMIT #{start},10") // 페이지 나누기 
   public List<DataBoardVO> databoardListData(int start);
   
   // 총페이지 
   @Select("SELECT CEIL(COUNT(*)/10.0) FROM databoard")
   public int databoardTotalPage();
}
