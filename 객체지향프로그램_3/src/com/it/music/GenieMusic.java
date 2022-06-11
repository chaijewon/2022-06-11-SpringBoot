package com.it.music;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GenieMusic {
   /*public static void main(String[] args) {
	    GenieMusic gm=new GenieMusic();
	    gm.getData();
   }*/
   public void getData()
   {
	   try
	   {
		  int k=1;
		  for(int i=1;i<=4;i++)
		  {
		     Document doc=Jsoup.connect("https://www.genie.co.kr/chart/top200?ditc=D&ymd=20220611&hh=15&rtm=Y&pg="+i).get();
		     Elements title=doc.select("table.list-wrap a.title");
		     Elements singer=doc.select("table.list-wrap a.artist");
		     Elements album=doc.select("table.list-wrap a.albumtitle");
		     /*
		      *    <img src="">
		      *    <a href="bbb">aaa</a>
		      *            ----  ----
		      *            attr() text()  => html()
		      *    <script></script> 
		      *    ------------------ data()
		      */
		     for(int j=0;j<title.size();j++)
		     {
		    	 System.out.println(k+"."+title.get(j).text()+" "
		    			 +singer.get(j).text()+" "
		    			 +album.get(j).text()+"=====>"
		    			 +getYoutubeData(title.get(j).text()));
		    	 k++;
		     }
		  }
	   }catch(Exception ex){}
   }
   public String getYoutubeData(String title)
   {
	   String key="";
	   try
	   {
		   Document doc=Jsoup.connect("https://www.youtube.com/results?search_query="+title).get();
		   Pattern p=Pattern.compile("/watch\\?v=[^가-힣]+");
		   // 영문 / 대소문자 , 특수문자 , 숫자 
		   Matcher m=p.matcher(doc.toString());
		   while(m.find())
		   {
			   // /watch?v=8dJyRm2jJ-U","webPageType":"WEB_PAGE_TYPE_WATCH","rootVe":3832}},"watchEndpoint":{"videoId":"8dJyRm2jJ-U","p
			   String s=m.group();// 데이터 읽기
			   key=s.substring(s.indexOf("=")+1,s.indexOf("\""));
			   break;
		   }
	   }catch(Exception ex){}
	   return key;
   }
}









