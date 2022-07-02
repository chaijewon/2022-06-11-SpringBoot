<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%--
      내장 객체 
   --------
        param   ========> <%= request.getParameter("id") %>  ==> ${param.id}
        paramValues ===> <%= request.getParameterValues("hobby")%> ==> ${paramValues.hobby}
        --------------
        requestScope ==> <%= request.getAttribute("id")%> ${requestScope.id}
                                                           --------------  생략이 가능 
                         => request.setAttribute("id","admin") => ${id} => admin
        sessionScope ==> <%= session.getAttribute("id")%> ${sessionScope.id}
                                                           --------------  생략이 가능 
                         => session.setAttribute("id","admin") => ${id} => admin 
                         
                         1. 우선순위 => requestScope 
                         2.        => sessionScope
                         request.setAttribute("id","admin1")
                         session.setAttribute("id2","admin2")  ==> ${id} => admin1
                         
        --------------
    
 --%>
<%
    String name="홍길동";
    String sex="남자";
    
    request.setAttribute("name", name);
    session.setAttribute("name1", "박문수");
    session.setAttribute("sex", sex);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   이름: ${name1 } , <%=request.getAttribute("name") %> <br>
  <%--                 key명 --%>
  성별: ${sessionScope.sex} , <%= session.getAttribute("sex") %>
  <%--               key명 --%>
</body>
</html>






