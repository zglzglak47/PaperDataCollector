package org.buaa.DataCollect.PaperCollect.ieee;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DetailURlExtractorIEEE {
	String url;
	List<String> tab_urls;
	String title;
	public DetailURlExtractorIEEE(String url){
		tab_urls = new ArrayList<String>();
		this.url = url;
		try{
			Document doc = Jsoup.connect(url).
					userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
					get();
			
			Elements script = doc.getElementsByTag("script");

			Pattern pattern = Pattern.compile("tab_[0-9a-zA-Z./?&=_]*'");
			Matcher matcher = pattern.matcher(script.html());
		    
//			System.out.println(matcher.find());
			while(matcher.find()){
				String s = matcher.group();
				tab_urls.add(s.substring(0, s.length()-1));
//				System.out.println(s);
			}
			
			title = doc.title();
			Element maindiv  = doc.getElementById("divmain");
			Elements titledivs =  maindiv.getElementsByClass("large-text");
			Element titlediv = titledivs.isEmpty()?null:titledivs.get(0);
			if (titlediv!=null){
				title = titlediv.text().trim();
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
		
	}
	
	List<String> getSubUrlList(){
		return tab_urls;
	}
	
	public String getTitle(){
		return title;
	}
}
