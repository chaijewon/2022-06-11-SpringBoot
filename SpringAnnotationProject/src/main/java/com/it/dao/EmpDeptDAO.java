package com.it.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.*;
// 기능 => 데이터베이스 연결 (스프링 컨테이너 관리) => 메모리 할당 요청 
@Repository // 자동 ID 생성 ==> 클래스명 (첫자만 소문자)
public class EmpDeptDAO {
   // 구현된 클래스의 주소를 자동으로 얻어 온다 (자동 주입 요청) => 수동 (getBean())
   @Autowired
   private EmpMapper mapper;
   
   public List<EmpVO> empListData()
   {
	   return mapper.empListData();
   }
   
   public List<DeptVO> deptListData()
   {
	   return mapper.deptListData();
   }
}



