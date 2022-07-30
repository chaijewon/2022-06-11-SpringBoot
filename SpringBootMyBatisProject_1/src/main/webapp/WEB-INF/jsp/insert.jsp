<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<style type="text/css">
.container{
  margin-top: 50px;
}
h1{
  text-align: center;
}
.row{
  margin: 0px auto;
  width:800px;
}
</style>
</head>
<body>
	<div class="container">
	   <h1>글쓰기</h1>
	   <div class="row">
	    <form method="post" action="insert_ok.do">
	    <table class="table table-hover">
	     <tr>
	       <td width=15% class="text-right danger">이름</td>
	       <td width=85%>
	        <input type=text name=name size=15 class="input-sm">
	       </td>
	     </tr>
	     <tr>
	       <td width=15% class="text-right danger">제목</td>
	       <td width=85%>
	        <input type=text name=subject size=60 class="input-sm">
	       </td>
	     </tr>
	     <tr>
	       <td width=15% class="text-right danger">내용</td>
	       <td width=85%>
	        <textarea rows="10" cols="65" name=content></textarea>
	       </td>
	     </tr>
	     <tr>
	       <td width=15% class="text-right danger">비밀번호</td>
	       <td width=85%>
	        <input type=password name=pwd size=10 class="input-sm">
	       </td>
	     </tr>
	     <tr>
	       <td colspan="2" class="text-center">
	        <input type=submit value="글쓰기" class="btn btn-sm btn-primary">
	        <input type=button value="취소" class="btn btn-sm btn-primary"
	         onclick="javascript:history.back()">
	       </td>
	     </tr>
	    </table>
	    </form>
	   </div>
	  </div>
</body>
</html>