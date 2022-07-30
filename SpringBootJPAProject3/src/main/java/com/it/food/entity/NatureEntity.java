package com.it.food.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="seoul_nature")
@Getter
@Setter
public class NatureEntity {
	@Id
	private int no;
	private String name,address,poster,msg;
  
}
