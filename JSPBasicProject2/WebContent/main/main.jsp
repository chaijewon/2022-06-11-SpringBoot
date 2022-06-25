<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
     String main_jsp="";
     String mode=request.getParameter("mode");
     int protocol=0;
     if(mode==null)
    	 mode="0";
     protocol=Integer.parseInt(mode);
     
     switch(protocol)
     {
        case 0:
        	main_jsp="../food/category.jsp";
        	break;
        case 1:
        	main_jsp="../food/food_list.jsp";
        	break;
        case 2:
        	main_jsp="../food/food_detail.jsp";
        	break;
        case 3:
        	main_jsp="../seoul/location.jsp";
        	break;
     }
%>
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
   width:100%
}
</style>
</head>
<body>
  <jsp:include page="../main/header.jsp"></jsp:include>
  <jsp:include page="<%= main_jsp %>"></jsp:include>
</body>
</html>




