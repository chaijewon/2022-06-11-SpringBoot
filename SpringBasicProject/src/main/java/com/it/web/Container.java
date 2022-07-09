package com.it.web;
// 클래스 관리 
import java.util.*;
// DL => key를 이용해서 해당 객체를 찾아 준다 
public class Container {
    private Map map=new HashMap();
    public Container()
    {
    	map.put("oracle",new Oracle());
    	map.put("mysql",new MySql());
    	map.put("mariadb",new MariaDB());
    }
    public Object getBean(String key)
    {
    	return map.get(key);
    }
}
