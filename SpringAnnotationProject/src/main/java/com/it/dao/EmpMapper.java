package com.it.dao;
// mybatis 

import org.apache.ibatis.annotations.Select;
import java.util.*;
public interface EmpMapper {
   @Select("SELECT * FROM emp")
   public List<EmpVO> empListData();
   
   @Select("SELECT * FROM dept")
   public List<DeptVO> deptListData();
   
   // => JOIN
   // => SubQuery
}
