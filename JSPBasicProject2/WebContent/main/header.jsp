<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="main.jsp">JSPExample</a>
    </div>
    <ul class="nav navbar-nav">
      <li class="active"><a href="main.jsp">Home</a></li>
      <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#"> 서울 여행 <span class="caret"></span></a>
        <ul class="dropdown-menu">
          <li><a href="main.jsp?mode=3">서울 명소</a></li>
          <li><a href="main.jsp?mode=4">서울 자연</a></li>
          <li><a href="main.jsp?mode=5">서울 호텔</a></li>
        </ul>
      </li>
      <li><a href="main.jsp?mode=6">맛집 검색</a></li>
      <li><a href="main.jsp?mode=7">커뮤니티</a></li>
    </ul>
  </div>
</nav>
</body>
</html>