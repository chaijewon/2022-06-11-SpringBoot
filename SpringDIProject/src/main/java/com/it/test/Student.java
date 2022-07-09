package com.it.test;
@Component("std")
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
