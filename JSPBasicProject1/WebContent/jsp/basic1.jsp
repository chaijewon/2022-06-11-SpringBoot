<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%--
       JSP (JavaServerPage) : 서버에서 실행하는 자바파일 
       ======================
       1. JSP 동작 과정 
          basic1.jsp  ====> tomcat ====> basic1_jsp.java 
       2. 지시자 
            page  <%@ page%>  ======
              => JSP에 대한 정보를 가지고 있다 
                 contentType : 변환 ===> html,xml,json(브라우저에서 실행하는 언어)
                      자바 => html   contentType="text/html;charset=UTF-8"
                      자바 => xml    contentType="text/xml;charset=UTF-8"
                      자바 => json   contentType="text/plain;charset=UTF-8"
                 import : 라이브러리 추가 
                 <%@ page import="java.util.*,java.io.*"%>
                 <%@ page import="java.util.*"%>
                 <%@ page import="java.io.*"%>
                 errorPage : 에러가 발생시에 이동하는 파일 지정  
            --------------------------
            include <%@ include%>
            taglib <%@ taglib%> 
            ---------------------------
       3. 스크립트 : 자바 소스코딩 => 자바/HTML 분리 
                  스크립트릿 : <% %> => 일반 자바 (변수선언 , 연산 , 제어문 , 메소드)
                  선언식 : <%! %> => 메소드 선언  => 사용빈도가 거의 없다 
                  표현식 : <%= %> => 데이터를 화면에 출력 
       4. 내장 객체 : 미리 선언된 객체 
           ***= request (HttpServletRequest) : 사용자 요청정보 , 브라우저 정보 
           ***= response (HttpServletResponse) : 서버응답 정보 , 화면 이동 정보 (리다이렉트)
           = out : 출력메모리에 대한 정보 
           ***= application : 서버 정보 (실제 경로)
           ***= session : 서버에 저장 
           = exception : 예외 처리 정보
           = pageContext : 화면 이동 , 파일 포함 , 다른 내장 객체 생성 => 액션 태그 
              <jsp:forward> <jsp:include> 
           = config : 환경설정 
           = page : 자신의 객체 => this
       
       5. 표현식(브라우저 출력) => ${} ==> MVC 
       6. taglib : <c:forEach> 자바 제어문 , 변수선언 , 날짜변환 => 태그로 변경 
       7. MVC : 자바와 HTML을 분리해서 사용 
          ----------------------------- Spring/SpringBoot => MVC
 --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <%
       String name="홍길동";
   %>
   <%= name %>
</body>
</html>







