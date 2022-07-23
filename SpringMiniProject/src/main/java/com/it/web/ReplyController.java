package com.it.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.*;

import javax.servlet.http.HttpSession;

import com.it.vo.*;
import com.it.dao.*;
@Controller
public class ReplyController {
   @Autowired
   private ReplyDAO dao;
   
   @RequestMapping("reply/reply_insert.do")
   public String replyInsert(ReplyVO vo,HttpSession session)
   {
	   String id=(String)session.getAttribute("id");
	   String name=(String)session.getAttribute("name");
	   vo.setId(id);
	   vo.setName(name);
	   dao.replyInsert(vo);
	   String url="";
	   if(vo.getType()==1)
		   url="redirect:../food/food_detail.do?no="+vo.getCno();
	   else if(vo.getType()==2)
		   url="redirect:../seoul/location_detail.do?no="+vo.getCno();
	   else if(vo.getType()==4)
		   url="redirect:../seoul/nature_detail.do?no="+vo.getCno();
	   return url;
   }
}
