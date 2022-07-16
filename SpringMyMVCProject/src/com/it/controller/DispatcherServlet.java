package com.it.controller;

import java.io.IOException;
import java.lang.reflect.Method;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
// => Controller 
import java.util.*;
public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try
		{
			// http://localhost/SpringMyMVCProject/list.do
			//                 ---------------------------
			//                 -------------------
			String cmd=request.getRequestURI();
			cmd=cmd.substring(request.getContextPath().length()+1);
			// HandlerMapping 
			Class clsName=Class.forName("com.it.controller.BoardController");
			Object obj=clsName.getDeclaredConstructor().newInstance();
			Method[] methods=clsName.getDeclaredMethods();
			for(Method m:methods)
			{
				RequestMapping rm=m.getAnnotation(RequestMapping.class);
				if(cmd.equals(rm.value()))
				{
					String jsp=(String)m.invoke(obj, request);
					ViewResolver vr=new ViewResolver();//JSP찾기
					String s=vr.jspFind(jsp);
					RequestDispatcher rd=request.getRequestDispatcher(s);
					rd.forward(request, response);
					return;
				}
			}
			//
		}catch(Exception ex){}
	}

}











