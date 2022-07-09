package com.it.web;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        Container c=new Container();
        Oracle o=(Oracle)c.getBean("oracle");
        System.out.println(o);
        o.getConnection();
        Oracle o1=(Oracle)c.getBean("oracle");
        System.out.println(o1);
        o1.getConnection();
        
        MySql m=(MySql)c.getBean("mysql");
        m.getConnection();
	}

}
