package com.it.anno;

import org.springframework.stereotype.Component;

/*
 *   메모리 할당 어노테이션 
 *   == 구분 
 *      @Component : 일반 클래스 
 *      @Repository : DAO (저장소)
 *      @Service : BI (DAO통합)
 *      @Controller : Model => 화면 처리
 *      @RestController : Model => 데이터만 전송 ==> VueJS 
 *      @ControllerAdvice : 통합 예외처리  
 *       
 *     
 */
@Component("std") // <bean id="std" class="com.it.anno.Student">
public class Student {
   public Student()
   {
	   System.out.println("Student() Call..");
   }
   public void display()
   {
	   System.out.println("Student:display Call...");
   }
}
