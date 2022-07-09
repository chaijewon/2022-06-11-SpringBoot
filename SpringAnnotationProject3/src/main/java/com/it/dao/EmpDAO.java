package com.it.dao;
import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository  // 메모리 할당 
public class EmpDAO {
   @Autowired
   private EmpMapper mapper; // 구현된 클래스주소 얻기 
   
   public List<EmpVO> empJoinData()
   {
	   return mapper.empjoinData();
   }
}
