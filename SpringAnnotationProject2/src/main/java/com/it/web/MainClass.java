package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;
// MainClass를 메모리 할당을 해라 
@Component
public class MainClass {
	@Autowired // 메모리 할당후에 Sawon객체의 주소를 주입해라
    private Sawon sa; // 스프링에 의해 자동으로 new Sawon()
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //1. 스프링 컨테이너에 클래스(등록) ==> xml
		ApplicationContext app=
				new ClassPathXmlApplicationContext("app.xml");
		/*
		 *   1. 클래스 메모리 할당 
		 *   2. setter DI
		 *   3. setter DI => 완료 확인 
		 *   4. 등록 =>  메소드 호출 (init-method)
		 *   -----------------------------------
		 *   프로그래머가 메소드 호출 
		 *   -----------------------------------
		 *   5. 소멸
		 */
		/*
		Sawon s=(Sawon)app.getBean("sa");// 수동으로 객체주소를 얻어 온다 
		s.setName("홍길동");
		s.setDept("개발부");
		s.setLoc("서울");
		s.print();*/
		MainClass mc=(MainClass)app.getBean("mainClass");
		mc.sa.setName("박문수");
        mc.sa.setDept("영업부");
        mc.sa.setLoc("부산");
        mc.sa.print();
	}

}
