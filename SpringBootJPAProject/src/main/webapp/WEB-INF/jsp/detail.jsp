<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
   width:800px;
}
</style>
</head>
<body>
  <div class="container">
   <h1 class="text-center">내용보기</h1>
   <div class="row">
     <table class="table">
      <tr>
       <th width=20% class="text-center success">번호</th>
       <td width=30% class="text-center">${vo.no }</td>
       <th width=20% class="text-center success">작성일</th>
       <td width=30% class="text-center">${vo.regdate }</td>
      </tr>
      <tr>
       <th width=20% class="text-center success">이름</th>
       <td width=30% class="text-center">${vo.name }</td>
       <th width=20% class="text-center success">조회수</th>
       <td width=30% class="text-center">${vo.hit }</td>
      </tr>
      <tr>
       <th width=20% class="text-center success">제목</th>
       <td colspan="3">${vo.subject }</td>
      </tr>
      <tr>
       <td colspan="4" class="text-left" valign="top" height="200"><pre>${vo.content }</pre></td>
      </tr>
      <tr>
       <td colspan="4" class="text-right">
         <a href="#" class="btn btn-xs btn-danger">수정</a>
         <a href="/delete/?no=${vo.no }" class="btn btn-xs btn-success">삭제</a>
         <a href="/" class="btn btn-xs btn-info">목록</a>
       </td>
      </tr>
     </table>
   </div>
  </div>
</body>
</html>







