<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="com.it.data.*,java.util.*"%>
<%
     Member mem=new Member();
     mem.setName("홍길동");
     mem.setAddr("서울");
     
     request.setAttribute("mem", mem);
     
     List<String> list=new ArrayList<String>();
     list.add("심청이");
     list.add("춘향이");
     list.add("박문수");
     
     request.setAttribute("list", list);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>EL에서 함수 호출</h1>
   이름 : ${mem.getName() }, ${mem.name }<br> <%-- getName()호출 --%>
   주소 : ${mem.getAddr() }, ${mem.addr }  <%-- getAddr() 호출 --%>
   <h1>ArrayList</h1>
   ${ list }
</body>
</html>








