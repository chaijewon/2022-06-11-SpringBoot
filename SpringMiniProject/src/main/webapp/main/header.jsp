<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<script type="text/javascript" src="http://code.jquery.com/jquery.js"></script>
<script type="text/javascript">
$(function(){
	$('#logBtn').click(function(){ // 이벤트 (로그인 버튼 클릭시 처리)
		let id=$('#id').val();
	    if(id.trim()=="")
	    {
	    	$('#id').focus();
	    	return;
	    }
	    let pwd=$('#pwd').val();
	    if(pwd.trim()=="")
	    {
	    	$('#pwd').focus();
	    	return;
	    }
	    
	    // id,pwd로 서버로 전송하고 결과값을 바로 받아 본다 => 처리 
	    $.ajax({
	    	type:'post',
	    	url:'../member/login.do',
	    	data:{"id":id,"pwd":pwd},
	    	success:function(res)
	    	{
	    		let result=res.trim();
	    		if(result=='NOID')
	    		{
	    			alert("아이디가 존재하지 않습니다");
	    			$('#id').val("");
	    			$('#pwd').val("");
	    			$('#id').focus();
	    		}
	    		else if(result=='NOPWD')
	    		{
	    			alert("비밀번호가 틀립니다");
	    			$('#pwd').val("");
	    			$('#pwd').focus();
	    		}
	    		else
	    		{
	    			location.href="../main/main.do";
	    		}
	    	}
	    })//ajax
	    
	})//click
})//function
</script>
</head>
<body>
<div class="wrapper row1">
  <header id="header" class="clear"> 
    <!-- ################################################################################################ -->
    <div id="logo" class="fl_left">
      <h1><a href="../main/main.do">맛집 & 레시피 & 여행</a></h1>
    </div>
    <div class="fl_right">
     <c:if test="${sessionScope.id==null }">
      <%--
          login.do ==> DispatcherServlet(Controller)
                            |위임(request) 
                          Model(RequestMapping())
          .do ==> Model
       --%>
      <!-- <form method="post" action="../member/login.do"> -->
	      <ul class="inline">
	        <li>ID:<input type=text id=id size=15 class="input-sm"></li>
	        <li>PW:<input type=password id=pwd size=15 class="input-sm"></li>
	        <li><input type=button id="logBtn" value="로그인" class="btn btn-lg btn-danger"></li>
	      </ul>
      <!-- </form> -->
     </c:if>
     <c:if test="${sessionScope.id!=null }">
      <form method="post" action="../member/logout.do">
       <ul class="inline">
        <li>${sessionScope.name }(${sessionScope.admin=="y"?"관리자":"일반사용자" })님 로그인되었습니다!!</li>
        <li><input type=submit value="로그아웃" class="btn btn-lg btn-danger"></li>
       </ul>
      </form>
     </c:if>
    </div>
    <!-- ################################################################################################ --> 
  </header>
</div>
<!-- ################################################################################################ --> 
<!-- ################################################################################################ --> 
<!-- ################################################################################################ -->
<div class="wrapper row2">
  <nav id="mainav" class="clear"> 
    <!-- ################################################################################################ -->
    <ul class="clear">
      <li class="active"><a href="../main/main.do">Home</a></li>
      <li><a class="drop" href="#">맛집</a>
        <ul>
          <li><a href="../food/location.do">지역별 맛집찾기</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">여행</a>
        <ul>
          <li><a href="../seoul/seoul_location.do">명소</a></li>
          <li><a href="../seoul/seoul_nature.do">자연/관광</a></li>
          <li><a href="../seoul/seoul_hotel.do">호텔</a></li>
          <li><a href="../seoul/seoul_weather.do">실시간 날씨 정보</a></li>
        </ul>
      </li>
      <li><a class="drop" href="#">커뮤니티</a>
        <ul>
          <li><a href="../freeboard/list.do">자유게시판</a></li>
          <li><a href="pages/sidebar-left.html">자료실</a></li>
        </ul>
      </li>
    </ul>
    <!-- ################################################################################################ --> 
  </nav>
</div>
</body>
</html>