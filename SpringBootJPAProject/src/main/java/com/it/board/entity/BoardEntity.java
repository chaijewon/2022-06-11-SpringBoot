package com.it.board.entity;

import java.time.LocalTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import lombok.Getter;
import lombok.Setter;

@Entity(name="board")
@Getter
@Setter
public class BoardEntity {
   @Id
   private int no;
   private String name,subject,content,pwd;
   private LocalTime regdate;
   private int hit;
   
   @PrePersist
   public void regdate()
   {
	   this.regdate=LocalTime.now();
   }
}
