<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    <h1>내용보기</h1>
    <div class="row">
       <table class="table">
        <tr>
         <th class="text-center" width=20%>번호</th>
         <td class="text-center" width=30%>${vo.no }</td>
         <th class="text-center" width=20%>작성일</th>
         <td class="text-center" width=30%>${vo.dbday }</td>
        </tr>
        <tr>
         <th class="text-center" width=20%>이름</th>
         <td class="text-center" width=30%>${vo.name }</td>
         <th class="text-center" width=20%>조회수</th>
         <td class="text-center" width=30%>${vo.hit }</td>
        </tr>
        <tr>
         <th class="text-center" width=20%>제목</th>
         <td colspan=3>${vo.subject }</td>
        </tr>
        <c:if test="${vo.filecount>0 }">
           <tr>
	         <th class="text-center" width=20%>첨부파일</th>
	         <td colspan=3>
	           <ul>
	            <%-- varStatus는 List의 인덱스번호 --%>
	            <c:forEach var="file" items="${nList }" varStatus="s">
	              <li>
	               <a href="download.do?fn=${file }">${file }</a>(${sList[s.index]}Bytes)
	              </li>
	            </c:forEach>
	           </ul>
	         </td>
	        </tr>
        </c:if>
        <tr>
          <td colspan="4" valign="top" class="text-left" height="200">
            ${vo.content }
          </td>
        </tr>
        <tr>
          <td colspan="4" valign="top" class="text-right" height="200">
            <a href="list.do" class="btn btn-xs btn-success">목록</a>
          </td>
        </tr>
       </table>
    </div>
   </div>
</body>
</html>





