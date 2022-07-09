package com.it.method;

public class Student {
    public void init()
    {
    	System.out.println("객체 생성 완료...");
    	// init-method => 드라이버 등록 , 서버 연결 ... 쿠키 읽기 (자동 로그인)
    }
    public void destory()
    {
    	System.out.println("객체 소멸 완료...");
    	// destory-method => 데이터베이스 닫기 , 서버 연결 해제 ....
    }
}
