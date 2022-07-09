package com.it.spring2;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainClass {
   public static void main(String[] args) {
	   ApplicationContext app=
			   new ClassPathXmlApplicationContext("app2.xml");
	   // 클래스 사용 
	   Sawon s1=(Sawon)app.getBean("sa");
	   Sawon s2=app.getBean("sa", Sawon.class);// 제네릭스 타입 (자동 형변환)
	   s1.setSabun(1);
	   s1.setName("홍길동");
	   
	   s2.setSabun(2);
	   s2.setName("박문수");
	   
	   // 출력 
	   s1.print();
	   s2.print();
	   
	   Sawon s3=(Sawon)app.getBean("sa1");
	   Sawon s4=app.getBean("sa1", Sawon.class);// 제네릭스 타입 (자동 형변환)
	   s3.setSabun(1);
	   s3.setName("홍길동");
	   
	   s4.setSabun(2);
	   s4.setName("박문수");
	   
	   // 출력 
	   s3.print();
	   s4.print();
   }
}
