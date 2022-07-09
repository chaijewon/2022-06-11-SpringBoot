package com.it.web;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app.xml");
        Student s1=(Student)app.getBean("std");
        s1.print();
        
        Student s2=(Student)app.getBean("std1");
        s2.print();
        
        Student s3=(Student)app.getBean("std2");
        s3.print();
	}

}
