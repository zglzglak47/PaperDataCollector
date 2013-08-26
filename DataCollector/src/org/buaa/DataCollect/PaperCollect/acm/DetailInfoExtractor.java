package org.buaa.DataCollect.PaperCollect.acm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DetailInfoExtractor {

	public static List<Map<String,String>> getAuthorAndUnit(String url){
		List<Map<String,String>> authors = new ArrayList<Map<String,String>>();
		try{
			Document doc = Jsoup.connect(url).
			userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
			get();
			Element maindiv  = doc.getElementById("divmain");
			Elements tbodys = maindiv.select("tbody");
			int i=0;
			Element authorsZone = null;
			for (Element e:tbodys ){
				i++;
				String t = e.text();
				if (t.startsWith("Author")){
					authorsZone = e;
				}
			}
			if (authorsZone ==  null ) {
				return authors;
			}
			
			
			
			Elements trs = authorsZone.select("tr");
			
			for (Element e: trs){
				Elements tds = e.select("td");
				if (tds.size()==3){
					Map<String,String> map = new HashMap<String,String>();					
						Element td1 = tds.get(1);
						Element td2 = tds.get(2);
						
						map.put("name", td1.text().trim());
						map.put("email", null);
						map.put("telephone", null);
						map.put("unit", td2.text().trim());
						map.put("address", null);
						
						authors.add(map);
				}
				
			}
		
			
			return authors;
			
		}catch(Exception e){
			
		}
		return authors;
	}
	
	public static String getAbstract(String url){
		try{
			Document doc = Jsoup.connect(url).
			userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
			get();
			
			return doc.body().text();
			
		}catch(Exception e){
			
		}
		return "error";
	}
	
	
	public static List<Map<String,String>> getAuthor(String url){
		
		List<Map<String,String>> authors = new ArrayList<Map<String,String>>();
		try{
			Document doc = Jsoup.connect(url).
			userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
			get();
			
			Elements hrefs = doc.getElementsByTag("a");
			for (Element link : hrefs) {
				  String linkHref = link.attr("href");
				  String linkText = link.text().trim();
//				  System.out.println(linkHref+":"+linkText);
//				  System.out.println(linkText);
				  if (linkText.compareTo("Bibliometrics")==0||
						  linkText.compareTo("View colleagues")==0
						  ||linkText.compareTo("homepage")==0 ){
					  //forgive this text
				  }else{
					  Map<String,String> map = new HashMap<String,String>();
						map.put("name", linkText);
						map.put("email", null);
						map.put("telephone", null);
						map.put("unit", null);
						map.put("address", null);
						
					  authors.add(map);
				  }
 				}
			
			return authors;
			
		}catch(Exception e){
			
		}
		return authors;
	}
	
	
	public static List<String> getArnumbers(String url){
		
		List<String> arnumbers = new ArrayList<String>();
		try{
			Document doc = Jsoup.connect(url).
			userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
			get();
			
			Elements hrefs = doc.getElementsByTag("a");
			for (Element link : hrefs) {
				  String herf =link.attr("href");
				  if (herf.startsWith("citation.cfm")){
					  System.out.println(herf);
					  arnumbers.add(herf);
				  }
 				}
			
			return arnumbers;
			
		}catch(Exception e){
//			e.printStackTrace();
			System.out.println("fail to connect volume page");
		}
		return arnumbers;
	}
	
}
