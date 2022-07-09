package com.it.xml;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        String path="C:\\Users\\Administrator\\git\\0611-springboot\\SpringBasicProject\\src\\main\\java\\com\\it\\xml\\app.xml";
        ApplicationContext app=
        		new ApplicationContext(path);
        Oracle o=(Oracle)app.getBean("oracle");
        o.getConnection();
        
        MySql m=(MySql)app.getBean("mysql");
        m.getConnection();
        
        MariaDB md=(MariaDB)app.getBean("mariadb");
        md.getConnection();
	}

}
