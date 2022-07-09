package com.it.anno;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component("mem") // <bean id="mem" class="com.it.anno.Member">
public class Member {
	   public Member()
	   {
		   System.out.println("Member() Call..");
	   }
	   public void display()
	   {
		   System.out.println("Member:display Call...");
	   }
}
