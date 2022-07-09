package com.it.dao;
/*
 *  empno int AI PK 
ename varchar(20) 
job varchar(20) 
mgr smallint 
hiredate date 
sal decimal(7,2) 
comm decimal(7,2) 
deptno int
 */
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class EmpVO {
   private int empno,mgr,sal,comm,deptno;
   private String ename,job,dbday;
   private Date hiredate;
   
}
