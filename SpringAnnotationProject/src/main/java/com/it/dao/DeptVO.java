package com.it.dao;

import lombok.Getter;
import lombok.Setter;

// 데이터형 (사용자 정의) => 스프링에 등록하지 않는다 
/*
 *  deptno int AI PK 
dname varchar(20) 
loc varchar(20)
 */
@Getter
@Setter
public class DeptVO {
   private int deptno;
   private String dname,loc;
}
