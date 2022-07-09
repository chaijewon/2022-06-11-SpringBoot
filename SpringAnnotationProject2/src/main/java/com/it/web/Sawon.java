package com.it.web;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
// 스프링에 의해 메모리 할당 요청 
@Component("sa") // <bean id="sa" class="com.it.web.Sawon">
// 객체의 생명주기 => 관리하는 클래스 (ApplicationContext) => Container
/*
 *    A a=new A(b);
 *    B b=new B();
 */
public class Sawon implements BeanFactoryAware,InitializingBean{
  private String name;
  private String dept;
  private String loc;
  public Sawon()
  {
	  System.out.println("Sawon()=> 메모리 할당");
  }
  public void print()
  {
	  System.out.println("이름:"+name);
	  System.out.println("부서명:"+dept);
	  System.out.println("근무지:"+loc);
  }

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("afterPropertiesSet() ... setterDI(setter에 값을 채운다)");
	}
	
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		// TODO Auto-generated method stub
		System.out.println("클래스를 Map에 저장...");
	}
}
