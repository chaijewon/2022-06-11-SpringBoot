<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>자바 String</h1>
  <%
      String s="Hello Java!!";
  %>
  문자 크기:<%=s.length() %><br>
 문자 자르기 : <%= s.substring(5) %>
 <h1>JSTL String</h1>
 <c:set var="ss" value="Hello Java!!"/>
  문자 크기 : ${fn:length(ss) }<br>
  문자 자르기 : ${fn:substring(ss,5,12) }
</body>
</html>










