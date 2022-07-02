package com.it.controller;

import java.io.*;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*
 *    Servlet => Server + let  => 서버에서 실행되는 가벼운 프로그램 
 *    -------- 톰캣에 의해 호출 : URL패턴을 만든다 
 *             *.do 
 *               /
 *     1) init => 초기화 (생성자와 비슷한 역할 수행) => XML 파싱  => 클래스 등록 
 *        => _jspInit()
 *     2) service() => 클라이언트당 한개씩 가지고 있다 
 *        --------- 클라이언트 요청에 대한 처리 (쓰레드에 의해 호출)
 *        => _jspService()
 *     3) destory() : 메모리 (새로고침 , 화면 이동) 해제 
 *        => _jspDestory() 
 *     ---------------------------------------------------------------
 *        service => doGet() : GET처리 
 *                   doPost() : POST처리 
 *                   
 *        => RequestMapping : GET/POST
 *           => GetMapping , PostMapping
 *           
 *     MVC 
 *     ----
 *      M : Model => 요청처리 => 결과값을 request,session에 담아 준다 
 *              => ~VO , ~DAO , ~Service , ~Manager
 *              => java
 *      V : View => 화면 출력 
 *              => jsp 
 *      C : Controller : 사용자 요청을 받는다 , 해당 JSP결과값을 전송 
 *              => Servlet , JSP 
 *                 -------- 스프링 (컨트롤러가 Servlet)
 *                 
 *      동작 
 *       1. 사용자 요청 ==> ~~~/list.do , detail.do ,insert.do , update.do...
 *                      -------------------------------------------DispatcherServlet을 찾는다
 *       2. DispatcherServlet (Controller) : 요청을 받는다 
 *       3. DispatcherServlet => 요청 처리하는 Model을 찾는다
 *       4. 요청을 처리하게 만든다 => Model이 가지고 있는 메소드 호출 
 *       5. 결과값을 받는다 => request,session에 담는다 
 *       6. 해당 JSP를 찾아서 전송 
 *          ------------------ ${}
 *       
 */
import java.util.*;
import com.it.model.*;
@WebServlet("*.do")
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Map clsMap=new HashMap();
	private String[] cls= {
		"com.it.model.ListModel",
		"com.it.model.InsertModel",
		"com.it.model.UpdateModel",
		"com.it.model.DetailModel",
		"com.it.model.DeleteModel"
	};
	private String[] cmd= {
			"list.do","insert.do","update.do","detail.do","delete.do"
	};
    // 자동 호출 
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		try
		{
			for(int i=0;i<cls.length;i++)
			{
				Class clsName=Class.forName(cls[i]);// 클래스 정보를 읽어 온다 
				Object obj=clsName.getDeclaredConstructor().newInstance();// 메모리 할당 
				clsMap.put(cmd[i], obj);
				System.out.println(cmd[i]+"==>"+obj);
			}
		}catch(Exception ex){}
	}
    // 클라이언트 요청시마다 호출 
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		System.out.println("Hello Controller!!");
	}

}







