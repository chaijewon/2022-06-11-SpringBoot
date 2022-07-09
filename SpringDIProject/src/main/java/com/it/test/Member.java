package com.it.test;

@Component("mem")
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
