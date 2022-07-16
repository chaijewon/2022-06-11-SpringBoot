package com.it.dao;
/*
 *  no int AI PK 
name varchar(34) 
subject varchar(1000) 
content text 
pwd varchar(10) 
regdate datetime 
hit int 
filename varchar(4000) 
filesize varchar(1000) 
filecount int
 */

import java.util.*;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
// 데이터베이스로부터 값을 받아서 브라우저(JSP)로 전송할 목적 => 읽기/쓰기 
@Setter
@Getter
/*
 *   List 
 *   
 *   <input type=text name="files[0]">
 */
public class DataBoardVO {
  private int no,hit,filecount;
  private String name,subject,content,pwd,filename,filesize,dbday;
  private Date regdate;
  private List<MultipartFile> files;
}






