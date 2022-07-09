package com.it.spring;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        Oracle o=(Oracle)app.getBean("oracle");
        o.getConnection();
        System.out.println(o);
        Oracle o1=(Oracle)app.getBean("oracle");
        o1.getConnection();
        System.out.println(o1);
        MySql m=(MySql)app.getBean("mysql");
        m.getConnection();
        
        MariaDB md=(MariaDB)app.getBean("mariadb");
        md.getConnection();
        
	}

}
