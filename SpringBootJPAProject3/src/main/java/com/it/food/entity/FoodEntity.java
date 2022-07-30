package com.it.food.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.Getter;
import lombok.Setter;

@Entity(name="food_category")
@Getter
@Setter
public class FoodEntity {
   @Id
   private int cno;
   private String title,poster,subject,link;
}
