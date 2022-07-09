package com.it.anno;

import org.springframework.stereotype.Component;

@Component("sa") // <bean id="sa" class="com.it.anno.Sawon">
public class Sawon {
	  public Sawon()
	   {
		   System.out.println("Sawon() Call..");
	   }
	   public void display()
	   {
		   System.out.println("Sawon:display Call...");
	   }
}
