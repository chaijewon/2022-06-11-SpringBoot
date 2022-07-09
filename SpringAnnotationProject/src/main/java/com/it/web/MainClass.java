package com.it.web;
import java.util.*;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.it.dao.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        EmpDeptDAO dao=(EmpDeptDAO)app.getBean("empDeptDAO");
        List<EmpVO> list=dao.empListData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEname()+" "+vo.getJob()+" "
        			+vo.getHiredate());
        }
        System.out.println("===============================");
        List<DeptVO> list2=dao.deptListData();
        for(DeptVO vo:list2)
        {
        	System.out.println(vo.getDeptno()+" "+vo.getDname()+" "+vo.getLoc());
        }
        
	}

}
