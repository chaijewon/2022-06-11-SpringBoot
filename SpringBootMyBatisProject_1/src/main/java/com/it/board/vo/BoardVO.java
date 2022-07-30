package com.it.board.vo;
import java.util.*;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
// MySql에서 데이터를 모아서 저장 
/*
 *    1. 스프링 프레임워크 => XML설정이 많이 존재 
 *    2. XML을 사용하지 않고 스프링 프레임워크 다루기 ==> 스프링 부트
 *    3. 스프링을 더 쉽게 이용이 가능하게 하는 도구 (스프링 부트)
 *       XML => application.properties을 이용해서 필요한 정보를 전송 
 *    4. 최근 => STS (프레임워크가 제거) => STS4 (부트)
 */
public class BoardVO {
   private int no,hit;
   private String name,subject,content,pwd,dbday;
   private Date regdate;
}
