package com.it.method;

import org.springframework.context.support.GenericApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        GenericApplicationContext app=
        		new GenericXmlApplicationContext("app3.xml");
        Student s=(Student)app.getBean("std");
        app.close();
        
	}

}
