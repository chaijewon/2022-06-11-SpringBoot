package com.it.web;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.it.config.EmpConfig;
import com.it.dao.*;
import java.util.*;
// 최근 => 스프링 (대부분 XML없이 => Java)
public class MainClass2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        AnnotationConfigApplicationContext app=
        		new AnnotationConfigApplicationContext(EmpConfig.class);
        EmpDAO dao=app.getBean("empDAO",EmpDAO.class);
        List<EmpVO> list=dao.empJoinData();
        for(EmpVO vo:list)
        {
        	System.out.println(vo.getEmpno()+" "
        			+vo.getEname()+" "
        			+vo.getJob()+" "
        			+vo.getDbday()+" "
        			+vo.getSal()+" "
        			+vo.getDvo().getDname()+" "
        			+vo.getDvo().getLoc());
        }
	}

}
