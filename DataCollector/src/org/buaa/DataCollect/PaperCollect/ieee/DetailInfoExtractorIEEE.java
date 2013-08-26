package org.buaa.DataCollect.PaperCollect.ieee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class DetailInfoExtractorIEEE {

	public static List<Map<String,String>> getAuthorAndUnit(String url){
		List<Map<String,String>> authors = new ArrayList<Map<String,String>>();
		try{
			Document doc = Jsoup.connect(url).
			userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
			get();
			
			
			Element maintabs = doc.getElementById("tabs-main");
			Element authordiv = maintabs.getElementById("abstractAuthors");	
//			System.out.println("div:"+authordiv.text());
			Elements alink = authordiv.select("a");
			Elements br = authordiv.select("br");
			if ((!alink.isEmpty()) && (!br.isEmpty())){

				Map<String,String> map = new HashMap<String,String>();
				Element span = alink.get(0).getElementById("authorAffiliations");
				String tmp = span.className();
				map.put("name", alink.get(0).text().trim());
				map.put("email", null);
				map.put("telephone", null);
				map.put("unit", tmp.trim());
				map.put("address", null);
				
				authors.add(map);
			}
			
			for (int i=1;i<alink.size();i++){

				Map<String,String> map = new HashMap<String,String>();
				map.put("name", alink.get(i).text().trim());
				map.put("email", null);
				map.put("telephone", null);
				map.put("unit", null);
				map.put("address", null);
				
				authors.add(map);
			}
			return authors;
			
		}catch(Exception e){
//			e.printStackTrace();
		}
		return authors;
	}
	
	public static String getAbstract(String url){
		try{
			Document doc = Jsoup.connect(url).
//			userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
			get();
			
			Element maintabs = doc.getElementById("tabs-main");
			Element absdiv = maintabs.getElementById("articleDetails");
			
			
			
			return absdiv.text();
			
		}catch(Exception e){
//			e.printStackTrace();
		}
		return "error";
	}
	
	public static List<String> getKeyword(String url){
		List<String> keyword = new ArrayList<String>();
		try{
			Document doc = Jsoup.connect(url).
			userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
			get();
			
			Element maintabs = doc.getElementById("tabs-main");
			Element keyworddiv = maintabs.getElementById("abstractKeywords");			
			
			Elements worddiv = keyworddiv.getElementsByClass("section");
			if (!worddiv.isEmpty()){
				Elements uls = worddiv.get(0).select("ul");
				
				for (int i=0;i<uls.size();i++){
					keyword.add(uls.get(i).text().trim());
				}
				
			}
			
			return keyword;
			
		}catch(Exception e){
//			e.printStackTrace();
		}
		return keyword;
	}
	
	public static String getTitle(String url){
		try{
			Document doc = Jsoup.connect(url).
			userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
			get();
			
			String title = (doc.title().split("-"))[1];
			
			return title;
			
		}catch(Exception e){
//			e.printStackTrace();
		}
		return "error";
	}
	
	
	/**
	 *  暂时无用
	 * @param url
	 * @return
	 */
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
//			e.printStackTrace();
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
				  if (herf.startsWith("/xpl/articleDetails.jsp?arnumber=")){
					  int a = herf.indexOf("arnumber=");
					  String uu = herf.substring(a, a+16);
					  System.out.println(uu);
					  arnumbers.add(uu);
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
