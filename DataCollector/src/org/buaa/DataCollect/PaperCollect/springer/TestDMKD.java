package org.buaa.DataCollect.PaperCollect.springer;

import java.io.File;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestDMKD {

	public static void main(String[] args) {
		File input = new File("F:\\gz\\Data\\html\\Using trees to mine multirelational databases - Springer.htm");
				try {
					Document doc = Jsoup.parse(input, "UTF-8", "http://link.springer.com/article/");
					/*Document doc = Jsoup.connect("http://link.springer.com/article/10.1007/s10618-011-0221-2").
							userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
							get();*/
					
					//title
					String title = doc.getElementsByTag("title").first().text().replace(" - Springer", "");
					System.out.println(title);
					
					//abstract
					String abst = doc.getElementsByClass("a-plus-plus").first().text();
					System.out.println(abst);
					
					//keywords
					Element e = doc.getElementById("abstract-about-keywords");
					Elements keyLis = e.getElementsByTag("li");
					String keywords = "";
					for (Element li : keyLis){
						keywords += li.text();
						keywords += ",";
					}
					keywords = keywords.substring(0, keywords.length() - 1);
					System.out.println(keywords);
					
					//authors
					Elements uls = doc.getElementsByTag("ul");
					int c = 0;
					Element auUl = null;
					for (Element ul : uls){
						if(ul.hasClass("authors"))
							c ++;				
						if(c == 2){
							auUl = ul;
							break;
						}
					}
					
					Map<String, String> emails = new HashMap<String, String>();
					Map<String, String> affis = new HashMap<String, String>();
					
					Elements auLis = auUl.getElementsByTag("li");
					for (Element li : auLis){
						String name = li.getElementsByClass("person").first().text();
						String email = li.getElementsByClass("envelope").first().attr("href");
						Element tag = li.getElementsByTag("sup").first();
						String affi = tag.attr("title");
						emails.put(name, email);
						affis.put(name, affi);
					}
					
					Set<Map.Entry<String, String>> setEmail = emails.entrySet();
			        for (Iterator<Map.Entry<String, String>> it = setEmail.iterator(); it.hasNext();) {
			            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			            System.out.println(entry.getKey() + "--->" + entry.getValue());
			        }
			        
			        Set<Map.Entry<String, String>> setAff = affis.entrySet();
			        for (Iterator<Map.Entry<String, String>> it = setAff.iterator(); it.hasNext();){
			        	Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
			        	System.out.println(entry.getKey() + "--->" + entry.getValue());
			        }
			        
			        //reference
			        Elements divs = doc.getElementsByTag("div");
			        Element refE = null;
			        for (Element div : divs){
			        	if (div.hasAttr("class") && div.attr("class").equals("formatted")){
			        		refE = div;
			        		break;
			        	}
			        }
			        
			        Elements refSpans = refE.getElementsByTag("span");
			        for (Element span : refSpans){
			        	String s = span.text();
			        	int idex1 = s.indexOf("(");
			        	int idex2 = s.indexOf(")");
			        	int idex3 = s.indexOf(".");
			        	String refNames = s.substring(0, idex1);
			        	String refYear = s.substring(idex1 + 1, idex2);
			        	String refTitle = s.substring(idex2 + 2, idex3);
			        	System.out.println(refNames);
			        	System.out.println(refYear);
			        	System.out.println(refTitle);
			        }
			        
				}catch(Exception e){
					e.printStackTrace();
				}
	}

}
