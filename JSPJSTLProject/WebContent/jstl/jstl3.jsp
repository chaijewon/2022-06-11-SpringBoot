<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,java.text.*"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
    Date date=new Date();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
  <h1>자바 날짜 변환 </h1>
  <%
      SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
      String today=sdf.format(date);
  %>
  오늘 날짜 : <%=today %>
  <h1>JSTL 날짜 변환</h1>
  <fmt:formatDate value="<%=date %>" pattern="yyyy-MM-dd"/>
  <h1>자바 숫자변환</h1>
  <%
      long won=123456;
      String s=String.format("%,d", won);
  %>
  <%= s %>
  <h1>JSTL 숫자변환</h1>
  <fmt:formatNumber  value="<%=won %>" pattern="###,###"></fmt:formatNumber>
</body>
</html>








