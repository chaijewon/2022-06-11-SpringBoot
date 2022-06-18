<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    //1. 사용자가 보내준 데이터 받기
    String mno=request.getParameter("mno");
    //2. 쿠키 생성(내장객체가 아니다) => 문자열만 저장이 가능 
    Cookie cookie=new Cookie("m"+mno,mno);
    //3. 저장위치
    cookie.setPath("/");
    //4. 저장 기간 
    cookie.setMaxAge(60*60*24); // 초단위 
    //5. 생성된 쿠키를 클라이언트로 전송 
    response.addCookie(cookie);
    //6. 화면 이동 => detail.jsp
    response.sendRedirect("detail.jsp?mno="+mno);
    
%>