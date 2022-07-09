package com.it.auto;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class MainClass {
	//@Autowired
	//@Qualifier("ms") // 한개 설정 => 특정 객체 설정 
	@Resource(name="ora") // 게시판 
    private MyDAO dao;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        ApplicationContext app=
        		new ClassPathXmlApplicationContext("app2.xml");
        MainClass mc=(MainClass)app.getBean("mainClass");
        mc.dao.getConnection();
        mc.dao.disConnection();
        
        /*MainClass m=new MainClass();
        m.dao.disConnection();
        m.dao.getConnection();*/
	}

}
