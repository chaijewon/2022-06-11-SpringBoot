package com.it.vo;

import lombok.Getter;
import lombok.Setter;

/*
 *  no int AI PK 
	name varchar(100) 
	address varchar(200) 
	poster varchar(200) 
	msg varchar(1000)
	
	=> seoul_location
	   seoul_nature 
 */
@Getter
@Setter
// 데이터베이스 값을 모아서 관리 (상태 관리) ==> VueJS , ReactJS 
public class SeoulVO {
    private int no;
    private String name,address,poster,msg;
}








