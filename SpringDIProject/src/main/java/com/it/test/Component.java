package com.it.test;

import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;
/*
 *   어노테이션은 기능은 없다 
 *   => 역할 => 인덱스 (찾기) , 조건 (if대신 사용이 가능)
 *   @Retention(RUNTIME) => 사용 기간 
 *    RUNTIME : 프로그램 종료시까지 
 *    SOURCE : 컴파일후에 사라진다 
 *    CLASS:
 *    
 *    @ => 클래스 구분  ===> TYPE
 *    public class ClassName
 *    {
 *        @ ==> FIELD (멤버 변수)
 *        String name
 *        
 *        @ ==> Contructor
 *        public ClassName()
 *        {
 *        }
 *        
 *        public void setName(@ String name)
 *        {                   PARAMETER
 *        }
 *        
 *        @ ==> 메소드  METHOD
 *        public void display()
 *        {
 *        }
 *    }
 */
@Retention(RUNTIME)
@Target(TYPE)
public @interface Component {
  public String value();
}
