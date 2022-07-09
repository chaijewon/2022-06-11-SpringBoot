package com.it.test;
import java.util.*;
import java.io.*;
public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="D:\\0611WeekDev\\Study\\SpringAnnotationProject2\\src\\main\\java\\";
        String pack="com.it.web";
        
        path=path+pack.replace(".", "\\");
        try
        {
        	File dir=new File(path);
        	File[] list=dir.listFiles();
        	for(File f:list)
        	{
        		//System.out.println(f.getName());
        		String ext=f.getName().substring(f.getName().lastIndexOf(".")+1);
        		if(ext.equals("java"))
        		{
        			System.out.println(f.getName());
        			String s1=f.getName().substring(0,f.getName().lastIndexOf("."));
        			s1=pack+"."+s1;
        			System.out.println(s1);
        			Class clsName=Class.forName(s1);
        			Object obj=clsName.getDeclaredConstructor().newInstance();
        			System.out.println(obj);
        		}
        	}
        }catch(Exception ex){}
	}

}

