package com.it.music;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class GenieMusic extends Music{

	@Override
	public void getData() {
		// TODO Auto-generated method stub
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

}
