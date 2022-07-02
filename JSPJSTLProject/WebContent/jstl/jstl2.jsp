<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%--
       <c:if> : 조건문
       <c:forEach>: 반복문
       <c:forTokens> : StringTokenizer
       <c:choose> : switch , 다중 조건문
 --%>
<%
    List<String> list=new ArrayList<String>();
    list.add("홍길동1");
    list.add("홍길동2");
    list.add("홍길동3");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>자바 For문</h1>
   <%
       for(int i=1;i<=10;i++)
       {
   %>
           <%=i+" " %>
   <%
       }
   %>
   <h1>JSTL forEach문</h1>
   <%-- 단점 : 감소는 할 수 없다 --%>
   <c:forEach var="i" begin="1" end="10" step="1">
       ${i }&nbsp;
   </c:forEach>
   <h1>자바 for-each</h1>
   <%
      for(String name:list)
      {
   %>
          <%= name %><br>
   <%
      }
   %>
   <c:set var="list" value="<%=list %>"/><%-- request.setAttribute("list",list) --%>
   <h1>JSTL for-each</h1>
   <c:forEach var="name" items="${list }">
      ${name }<br>
   </c:forEach>
   <h1>StringTokenizer 사용</h1>
   <%
        String color="red,blue,green,black,yellow";
        StringTokenizer st=new StringTokenizer(color,",");
        while(st.hasMoreTokens())
        {
   %>
           <%=st.nextToken() %><br>
   <%
        }
   %>
   <c:set var="color" value="<%=color %>"/>
   <h1>JSTL 사용</h1>
   <%-- col=> st.nextToken() --%>
   <c:forTokens items="${color }" delims="," var="col">
      ${col }<br> 
   </c:forTokens>
   <h1>자바 if</h1>
   <%
       for(int i=1;i<=10;i++)
       {
    	   if(i%2==0)
    	   {
   %>
               <%= i %>&nbsp;
   <%
    	   }
       }
   %>
   <h1>JSTL if</h1>
   <c:forEach var="i" begin="1" end="10">
     <c:if test="${i%2==0 }">
       ${i }&nbsp;
     </c:if>
   </c:forEach>
   <h1>자바 다중 조건문</h1>
   <%
        int sex=1;
   
        if(sex==1)
        {
   %>
                  성별은 남자입니다
   <%
        }
        else if(sex==2)
        {
   %>
                  성별은 여자입니다
   <%
        }
        else 
        {
   %>
                   외국인입니다
   <%
        }
   %>
   <h1>JSTL 다중 조건문</h1>
   <c:set var="sex" value="2"/>
   <c:choose>
     <c:when test="${sex==1 }"> <%-- if(sex==1) --%>
       성별은 남자입니다
     </c:when>
     <c:when test="${sex==2 }"> <%-- else if(sex==2) --%>
     성별은 여자입니다
     </c:when>
     <c:otherwise> <%-- else --%>
     외국인입니다
     </c:otherwise>
   </c:choose>
</body>
</html>










