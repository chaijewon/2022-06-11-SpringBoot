<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
      <core:
      JSTL : JavaServer Pages Standard Tag Library => Java문법 => 태그형변환 
      -----
        core / format / fn / sql / xml
                             ---------- ORM , OXM
        core : 변수 선언 , 제어문 , 화면 이동  , 화면 출력 
               1) 변수 선언 
                  <c:set var="" value=""> 
                                예)
                      <c:set var="name" value="홍길동">
                             ========== ==============
                                 key        value
                         => request.setAttribute("name","홍길동")
               2) 화면 출력 
                      <c:out value="홍길동"> => <%= "홍길동" %>
               3) 화면 이동 
                      ***<c:redirect url="a.jsp"> => response.sendRedirect("a.jsp");
                      
               ****** JSP는 자바를 사용하지 않는다 
               4) 제어문 
                  ***<c:if> ==> 조건문 => 단점 (<c:else>가 없다)
                  ***<c:forEach> => for
                  <c:forTokens> => StringTokenizer
                  <c:choose> => switch 
        format : 날짜 , 숫자 변환 
                1) <fmt:formatDate> => SimpleFormatDate()
                2) <fmt:formatNumber> => 10,000
        fn : String관련함수 => ${fn:substring()} , ${fn:trim()}... 자바에서 보통 처리 
--%>
<%
    String id="admin";
    //request.setAttribute("id", id);
%>
<c:set var="id" value="<%=id %>"/>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   ID : <%= id %> <br>
   ID : ${id } <br>
   ID : <c:out value="${id }"/><br> <%-- 그래프 : JQuery => $ --%>
   ID : <c:out value="<%=id %>"/>
</body>
</html>




