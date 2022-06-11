package com.it.music;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

public class MelonMusic extends Music{

	@Override
	public void getData() {
		// TODO Auto-generated method stub
		try
		{
			Document doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			Elements title=doc.select("tr.lst50 div.rank01");
			Elements singer=doc.select("tr.lst50 div.rank02");
			Elements album=doc.select("tr.lst50 div.rank03");
			
			for(int j=0;j<title.size();j++)
			{
				System.out.println((j+1)+"."+title.get(j).text()+" "
		    			 +singer.get(j).text()+" "
		    			 +album.get(j).text()+"=====>"
		    			 +getYoutubeData(title.get(j).text()));
			}
			
			doc=Jsoup.connect("https://www.melon.com/chart/index.htm").get();
			title=doc.select("tr.lst100 div.rank01");
			singer=doc.select("tr.lst100 div.rank02");
			album=doc.select("tr.lst100 div.rank03");
			
			for(int j=0;j<title.size();j++)
			{
				System.out.println((j+51)+"."+title.get(j).text()+" "
		    			 +singer.get(j).text()+" "
		    			 +album.get(j).text()+"=====>"
		    			 +getYoutubeData(title.get(j).text()));
			}
		}catch(Exception ex) {}
	}

}
