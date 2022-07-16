package com.sist.test;

import java.lang.reflect.Method;
import java.util.Scanner;

class Controller
{
	@RequestMapping("a.do")
	public void aaa()
	{
		System.out.println("a.do => 처리 메소드 호출");
	}
	@RequestMapping("b.do")
	public void bbb()
	{
		System.out.println("b.do => 처리 메소드 호출");
	}
	@RequestMapping("c.do")
	public void ccc()
	{
		System.out.println("c.do => 처리 메소드 호출");
	}
}
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        try
        {
        	Scanner scan=new Scanner(System.in);
        	System.out.print("URL입력:");
        	String cmd=scan.next(); // 브라우저에서 사이트 주소 
        	Class clsName=Class.forName("com.sist.test.Controller");
        	Object obj=clsName.getDeclaredConstructor().newInstance();
        	Method[] methods=clsName.getDeclaredMethods();
        	for(Method m:methods)
        	{
        		//System.out.println(m.getName());
        		RequestMapping rm=m.getAnnotation(RequestMapping.class);
        		if(rm.value().equals(cmd))
        		{
        			m.invoke(obj, null);
        		}
        	}
        }catch(Exception ex) {}
	}

}






