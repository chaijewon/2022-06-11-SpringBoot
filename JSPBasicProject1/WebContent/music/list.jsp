<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<%@ page import="com.sist.main.*" %>
<%
    //1. DAO로부터 데이터를 받는다 => html(출력) , 자바(데이터 관리)
    MusicDAO dao=new MusicDAO();
    String cno=request.getParameter("cno"); // 버튼 클릭시 
    String strPage=request.getParameter("page"); // page는 내장 객체 
    /*
         list.jsp?cno=
         ------------- cno=""
         list.jsp
         -------- cno=null
         
                에러 
            ***404 : 파일이 없는 경우 
            ***500 : 자바 소스에러 
            412 : 한글 변환 
            400 : 데이터값을 잘못 받는 경우 => 스프링 
            413 : 접속 금지 
            200 : 정상 수행 
    */
    // 맨처음에는 선택이 불가능 
    if(cno==null)
    	cno="1";
    if(strPage==null)
    	strPage="1";
    // 현재 페이지 
    int curpage=Integer.parseInt(strPage); // 문자열을 정수로 변경 
    // 실제 데이터를 가지고 온다
    List<Music> list=dao.musicListData(curpage, Integer.parseInt(cno));
    for(Music m:list)
    {
    	String s=m.getTitle();
    	if(s.length()>25)
    	{
    		s=s.substring(0,25)+"...";
    		m.setTitle(s);
    	}
    	m.setTitle(s);
    }
    // 총페이지 
    int totalpage=dao.musicTotalPage(Integer.parseInt(cno));
    /*
         request : 사용자가 보내준 데이터를 받을수 있다 
                클래스명 => HttpServletRequest => 미래 생성이된 객체 (내장 , 기본객체)
                 기능 (메소드)
                1) 단일값 => getParameter("키") => ?cno=1
                                                 ---- -- value 
                                                  key
                2) 다중값 (checkbox) => getParameterValues() => String[]
                3) 한글변환 ( 한글 ====> 브라우저 ===== 자바)
                                encoding     decoding
                                       자바==== %EC%9E%90%EB%B0%94 == 자바
                     setCharacterEncoding("UTF-8");
                     http://localhost/JSPBasicProject1/music/list.jsp => URL
                    		         ---------------------------------
                    		                        URI
                    		         ----------------- ContextPath
                4) getRequestURI() 
                5) getContextPath()
                6) getRemoteAddr() : 클라이언트의 IP
    */
    
    //1. Cookie읽기
    List<Music> cList=new ArrayList<Music>();
    Cookie[] cookies=request.getCookies();
    if(cookies!=null)//cookie가 존재한다면
    {
    	for(int i=cookies.length-1;i>=0;i--)
    	{
    		if(cookies[i].getName().startsWith("m"))
    		{
    			String mno=cookies[i].getValue();
    			Music mm=dao.musicDetailData(Integer.parseInt(mno));
    			cList.add(mm);
    		}
    	}
    }
%>
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
.row {
   margin: 0px auto;
   width:100%
}
</style>
</head>
<body>
  <div class="container">
    <div class="row">
      <div class="text-center">
        <a href="list.jsp?cno=1" class="btn btn-sm btn-danger">Top100</a>
        <a href="list.jsp?cno=2" class="btn btn-sm btn-info">가요</a>
        <a href="list.jsp?cno=3" class="btn btn-sm btn-success">POP</a>
        <a href="list.jsp?cno=4" class="btn btn-sm btn-primary">OST</a>
        <a href="list.jsp?cno=5" class="btn btn-sm btn-default">트롯</a>
      </div>
      <div style="height: 30px"></div>
      <div class="row">
        <%
            for(Music m:list)
            {
        %>
                 <div class="col-md-3">
				    <div class="thumbnail">
				      <a href="detail_before.jsp?mno=<%=m.getMno()%>">
				        <img src="<%=m.getPoster() %>" alt="Lights" style="width:100%">
				        <div class="caption">
				          <p style="font-size: 8px"><%=m.getTitle() %></p>
				        </div>
				      </a>
				    </div>
				  </div>
        <%
            }
        %>
      </div>
    </div>
    <div class="row">
      <div class="text-center">
        <ul class="pagination">
        <%
            for(int i=1;i<=totalpage;i++)
            {
            	
        %>
                <li <%=i==curpage?"class=active":"" %>>
                 <a href="list.jsp?cno=<%=cno%>&page=<%=i%>"><%=i %></a>
                </li>
        <%
            	
            }
        %>
        </ul>
      </div>
    </div>
    <div class="row">
     <h3>최신 방문한 뮤직</h3>
     <a href="cookie.jsp" class="btn btn-sm btn-danger">쿠키 삭제</a>
     <hr>
     <%
      
      if(cList!=null && cList.size()>0)
      {
        for(int i=0;i<cList.size();i++)
        {
          if(i>10) break;
          Music m=cList.get(i);
     %>
          <img src="<%=m.getPoster() %>" style="width:100px;height: 100px">
     <%
        }
      }
     %>
    </div>
  </div>
</body>
</html>







