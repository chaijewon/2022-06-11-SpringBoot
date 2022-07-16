package com.it.controller;
// JSP를 찾는다 
public class ViewResolver {
   public String jspFind(String jsp)
   {
	   return "board/"+jsp+".jsp";
   }
}
