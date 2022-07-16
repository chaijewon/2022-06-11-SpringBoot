package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.net.URLEncoder;
import java.util.*;

import javax.servlet.http.HttpServletResponse;

import com.it.dao.*;
// 요청 처리 => 요청을 받아서 처리 => 결과값을 request,session => HandlerMapping
// 메모리 할당 
@Controller
@RequestMapping("databoard/")
// 공통 폴더 일 경우에 사용 
public class DataBoardController {
   // DAO의 주소를 읽어 온다 
   @Autowired
   private DataBoardDAO dao;
   
   // 메소드 ==> 모든 단일 데이터는 해당 데이터형이 필요하다 ==> String으로 받을 수 있다 
   // int page ==> Integer.parseInt(null)
   @RequestMapping("list.do")
   public String databoard_list(String page,Model model)
   {
	   // request에 값을 모아서 전송 => 데이터를 JSP로 전송하는 객체 => Model(전송 객체)
	   if(page==null)
		   page="1"; // 디폴트 
	   
	   int curpage=Integer.parseInt(page); // 현재 페이지 
	   int start=(curpage*10)-10;
	   List<DataBoardVO> list=dao.databoardListData(start);
	   model.addAttribute("list", list);// model=request 대신 사용 
	   /*
	    *   class Model 
	    *   {
	    *      HttpServletRequest request;
	    *      public void addAttribute(String key,Object obj)
	    *      {
	    *          request.setAttribute(key,obj);
	    *      }
	    *   }
	    */
	   // 페이지 나누기 => 총페이지 
	   int totalpage=dao.databoardTotalPage();
	   
	   model.addAttribute("curpage", curpage);
	   model.addAttribute("totalpage", totalpage);
	   return "databoard/list";
   }
   @RequestMapping("insert.do")
   public String databoard_insert()
   {
	   return "databoard/insert"; // forward
   }
   @RequestMapping("insert_ok.do")
   public String databoard_insert_ok(DataBoardVO vo)
   {
	   // 커맨드 객체 
	   List<MultipartFile> list=vo.getFiles();
	   System.out.println(list);
	   if(list==null) // 파일업로드가 안된 경우 
	   {
		   vo.setFilename("");
		   vo.setFilesize("");
		   vo.setFilecount(0);
	   }
	   else 
	   {
		   String tempFile="";
		   String tempSize="";
		   for(MultipartFile mf:list)
		   {
			   try
			   {
				   String strFile=mf.getOriginalFilename();// 업로드된 파일명 읽기
				   File file=new File("D:\\0611WeekDev\\upload\\"+strFile);//업로드
				   mf.transferTo(file);
				   
				   tempFile+=strFile+",";// a.jpg,b.jpg....,
				   tempSize+=file.length()+",";
			   }catch(Exception ex) {}
		   }
		   
		   tempFile=tempFile.substring(0,tempFile.lastIndexOf(","));
		   tempSize=tempSize.substring(0,tempSize.lastIndexOf(","));
		   vo.setFilename(tempFile);
		   vo.setFilesize(tempSize);
		   vo.setFilecount(list.size());
	   }
	   // DAO에 추가 
	   dao.databoardInsert(vo);
	   // 화면 이동 => list.jsp (재호출) => sendRedirect() => request를 전송 
	   return "redirect:list.do";
	   /*
	    *   JSP 
	    *   화면 이동 
	    *     => forward ==> request를 전송 받는다 
	    *     => sendRedirect => request를 초기화후에 다른 파일로 이동 
	    *        => _ok , (insert_ok, update_ok, delete_ok)
	    */
   }
   @RequestMapping("detail.do")// 상세보기 
   public String databoard_detail(int no,Model model)
   {
	   DataBoardVO vo=dao.databoardDetailData(no);
	   
	   List<String> nList=new ArrayList<String>();
	   List<String> sList=new ArrayList<String>();
	   
	   if(vo.getFilecount()>0)
	   {
	      StringTokenizer st=new StringTokenizer(vo.getFilename(),",");
	      while(st.hasMoreTokens())
	      {
	    	  nList.add(st.nextToken());
	      }
	      
	      st=new StringTokenizer(vo.getFilesize(),",");
	      while(st.hasMoreTokens())
	      {
	    	  sList.add(st.nextToken());
	      }
	   }
	   
	   // 데이터 전송 
	   model.addAttribute("vo", vo);
	   model.addAttribute("nList", nList);
	   model.addAttribute("sList", sList);
	   return "databoard/detail";
   }
   @RequestMapping("download.do")
   public void databoard_download(String fn,HttpServletResponse response)
   {
	   try
	   {
		   File file=new File("D:\\0611WeekDev\\upload\\"+fn);
		   response.setHeader("Content-Disposition", "attachement;filename="
				              +URLEncoder.encode(fn, "UTF-8"));
		   response.setContentLength((int)file.length());
		   
		   BufferedInputStream bis=new BufferedInputStream(new FileInputStream(file));
		   // 서버에 있는 파일 읽기
		   BufferedOutputStream bos=new BufferedOutputStream(response.getOutputStream());
		   // 다운로드 하는 사람 
		   byte[] buffer=new byte[1024];
		   int i=0; // 읽은 바이트 
		   while((i=bis.read(buffer, 0, 1024))!=-1) //-1 (EOF)
		   {
			   bos.write(buffer, 0, i);
		   }
		   bis.close();
		   bos.close();
	   }catch(Exception ex){}
   }
}






