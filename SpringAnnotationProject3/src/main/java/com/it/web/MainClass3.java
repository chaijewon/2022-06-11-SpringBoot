package com.it.web;
/*
 *   1. Spring 
 *      ======== 사용자 정의 클래스를 관리하는 역할 
 *               -------------- 생성 ~ 소멸 ======> 핵심 코딩  (컨테이너) 
 *      = 컨테이너 (객체의 생명 주기 담당) 
 *          BeanFactory 
 *             |
 *          ApplicationContext
 *             |
 *             = GenericApplicationContext(컨테이너 종료)
 *             = ***AnnotationConfigApplicationContext(자바로 설정 파일을 만든 경우에 사용)
 *             = WebApplicationContext(웹에서 사용)
 *     = 컨테이너의 기능 
 *          1) DL : 클래스 찾기 
 *          2) DI : 객체 생성시 필요한 데이터 주입 => (Setter,Constructor) 
 *                  객체 생성시 , 소멸시 => 필요한 메소드를 자동 호출이 가능 
 *     = 객체 생성시에 
 *         = 한개만 사용  => scope="singleton"
 *         = 여러개 사용  => scope="prototype"
 *     = 객체 주소를 스프링에서 가지고 올때 
 *         = 수동 ==> getBean("id")
 *         = 자동 ==> @Autowired
 *     ------------------------------------------------------- core
 *     = AOP => Transaction , Security => 공통기반 => 자동 호출 
 *     = MVC => 웹 => Task(Batch) , Validation
 *     ------------------------------------------------------- 최신 기술(Spring-Boot)  
 */
public class MainClass3 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
