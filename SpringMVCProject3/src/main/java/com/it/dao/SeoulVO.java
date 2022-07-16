package com.it.dao;

import lombok.Getter;
import lombok.Setter;

/*
 *  no int AI PK 
name varchar(100) 
address varchar(200) 
poster varchar(200) 
msg varchar(1000)
 */
@Getter
@Setter
public class SeoulVO {
   private int no;
   private String name,address,poster,msg;
}
