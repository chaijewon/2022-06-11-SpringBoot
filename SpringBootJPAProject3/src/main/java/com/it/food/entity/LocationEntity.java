package com.it.food.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="seoul_location")
/*
 *  no int AI PK 
name varchar(100) 
address varchar(200) 
poster varchar(200) 
msg varchar(1000)
 */
@Getter
@Setter
public class LocationEntity {
   @Id
   private int no;
   private String name,address,poster,msg;
}
