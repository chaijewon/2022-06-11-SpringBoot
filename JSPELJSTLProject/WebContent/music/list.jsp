<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,com.it.dao.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
   String cno=request.getParameter("cno");
   if(cno==null)
	   cno="1";
   //1. 데이터 읽기
   MusicDAO dao=MusicDAO.newInstance();
   List<MusicVO> list=dao.musicListData(Integer.parseInt(cno));
   // 웹 => 자바역할 (요청처리 => 데이터를 JSP로 전송) => 데이터 관리 
%>
<c:set var="list" value="<%=list %>"/> <%-- request.setAttribute("list",list) --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
<style type="text/css">
.container{
  margin-top: 50px;
}
.row {
   margin: 0px auto;
   width:100%;
}
</style>
</head>
<body>
   <div class="container">
     <h1 class="text-center">지니뮤직</h1>
     <div class="row">
       <a href="list.jsp?cno=1" class="btn btn-sm btn-danger">Top100</a>
       <a href="list.jsp?cno=2" class="btn btn-sm btn-success">가요</a>
       <a href="list.jsp?cno=3" class="btn btn-sm btn-info">POP</a>
       <a href="list.jsp?cno=4" class="btn btn-sm btn-primary">OST</a>
       <a href="list.jsp?cno=5" class="btn btn-sm btn-danger">트롯</a>
       <a href="list.jsp?cno=6" class="btn btn-sm btn-success">JAZZ</a>
       <a href="list.jsp?cno=7" class="btn btn-sm btn-info">CLASSIC</a>
     </div>
     <div style="height: 30px"></div>
     <div class="row">
       <table class="table">
         <tr>
           <th class="text-center">순위</th>
           <th class="text-center">등폭</th>
           <th class="text-center"></th>
           <th class="text-center">곡명</th>
           <th class="text-center">가수명</th>
         </tr>
         <%-- for(MusicVO vo:list) --%>
         <c:forEach var="vo" items="${list }">
           <tr>
             <td class="text-center">${vo.mno }</td>
             <td class="text-center">
               <c:choose>
                 <c:when test="${vo.state=='상승' }">
                   <span style="color:red">▲&nbsp;${vo.idcrement }</span>
                 </c:when>
                 <c:when test="${vo.state=='하강' }">
                   <span style="color:blue">▼&nbsp;${vo.idcrement }</span>
                 </c:when>
                 <c:otherwise>
                   <span style="color:gray">-</span>
                 </c:otherwise>
               </c:choose>
             </td>
             <td class="text-center">
               <img src="${vo.poster }" width=30 height="30">
             </td>
             <td>${vo.title }</td>
             <td>${vo.singer }</td>
           </tr>
         </c:forEach>
       </table>
     </div>
   </div>
</body>
</html>







