package com.it.vo;
/*
 *   no int AI PK 
cno int 
type int 
id varchar(20) 
name varchar(34) 
msg text 
regdate datetime
 */
import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReplyVO {
   private int no,cno,type;
   private String id,name,msg;
   private Date regdate;
}
