package com.it.constuctor;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
/*
 *   DL => 메모리 할당 => 클래스 찾기 
 *   DI => 멤버변수 초기화 
 *  -----
 *      1. setter DI => set메소드에 값 주입 
 *      2. constructor DI => 생성자 매개변수 이용 
 *      3. method DI 
 *            = 객체 생성  => init-method
 *            = 객체 소멸  => destory-method 
 *     --------------------------------------- Spring 5 => 보안 (XML노출 (X), Java
 *      4. XML분리시 처리 
 *      --------------------------------------
 */
@AllArgsConstructor
public class Student {
   private int hakbun;
   private String name;
   private int kor,eng,math;
   public void print()
   {
	   System.out.println("학번:"+hakbun);
	   System.out.println("이름:"+name);
	   System.out.println("국어점수:"+kor);
	   System.out.println("영어점수:"+eng);
	   System.out.println("수학점수:"+math);
   }
}
