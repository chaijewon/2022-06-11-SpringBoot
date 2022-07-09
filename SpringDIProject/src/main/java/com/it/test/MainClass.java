package com.it.test;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 try
	     {
	        	List<String> list=new ArrayList<String>();
	        	list.add("com.it.test.Member");
	        	list.add("com.it.test.Sawon");
	        	list.add("com.it.test.Student");
	        	list.add("com.it.test.Test");
	        	for(String cls:list)
	        	{
	        		Class clsName=Class.forName(cls);
	        		if(clsName.isAnnotationPresent(Component.class)==false)
	        			      continue;
	        		// 메모리 할당 
	        		Object obj=clsName.getDeclaredConstructor().newInstance();
	        		//                 생성자 호출                              객체 생성 
	        		System.out.println(obj);
	        	}
	      }catch(Exception ex){}
	}

}






