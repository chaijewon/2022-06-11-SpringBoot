package com.it.spring2;

public class Sawon {
   private int sabun;
   private String name;
   
   public int getSabun() {
	return sabun;
	}
	
	public void setSabun(int sabun) {
		this.sabun = sabun;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public void print() 
   {
	   System.out.println(sabun+" "+name);
   }
}
