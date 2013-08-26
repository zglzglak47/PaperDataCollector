package org.buaa.DataCollect.PaperCollect.elsevier;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestDKE {

	public static void main(String[] args) {
		//File input = new File("F:\\gz\\Data\\html\\Repairing inconsistent dimensions in data warehouses.htm");
		try {
			//Document doc = Jsoup.parse(input, "UTF-8", "http://www.sciencedirect.com/science/");
			
			Document doc = Jsoup.connect("http://www.sciencedirect.com/science/article/pii/S0169023X12000274").
					userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
					get();
			
			//title
			String title = doc.title();
			System.out.println(title + '\n');
			
			//abstract
			String abst = doc.getElementById("sp0005").text();
			System.out.println(abst);
			
			//keywords
			String keyword = doc.getElementsByClass("keyword").first().text();
			System.out.println(keyword);
			
			//author name&email&unit			
			
			/*
			 * authors对应emails
			 * unit和author可能有角标abc对应，可能没有，has_abc
			 * has_abc：map表示，affs为空
			 * !has_abc：affs表示，affs.size()与authors。size()可能不相等
			 * */
			
			Map<String, String> authorMap = new HashMap<String, String>();
			Map<String, String> affMap = new HashMap<String, String>();
			List<String> authors = new ArrayList<String>();
			List<String> emails = new ArrayList<String>(); 
			List<String> affs = new ArrayList<String>(); 
		
			boolean has_abc = false;
			Elements allHrefs = doc.getElementsByTag("a");
			for(Element href2 : allHrefs){
				if(href2.hasAttr("title") && href2.attr("title").contains("Affiliation")){
					has_abc = true;
					break;
				}
			}
			
			Elements lis = doc.getElementsByTag("li");
			for(Element li : lis){
				Elements hrefs = li.getElementsByTag("a");
				boolean hasAuthor = false;
				boolean hasEmail = false;
				for(Element href : hrefs){
					if(href.hasClass("authorName")){						
						authors.add(href.text());
						if (has_abc){
							String abc = li.after(href).getElementsByTag("a").first().text();
							authorMap.put(abc, href.text());
						}
						hasAuthor = true;
						break;
					}
				}
				if(hasAuthor){
					for(Element href1 : hrefs){
						if(href1.attr("href").contains("@")){
							emails.add(href1.attr("href"));
							hasEmail = true;
							break;
						}
					}
					if(!hasEmail){
						emails.add("");
					}
				}				
			}
			
			Elements uls = doc.getElementsByTag("ul");
			Element affiliation = null;
			for (Element ul : uls){
				if (ul.hasAttr("class") && ul.attr("class").equals("affiliation")){
					affiliation = ul;
					//System.out.println(ul.text());
					break;
				}
			}
			if(affiliation != null){	
				Elements aff_lis = affiliation.getElementsByTag("li");
				if (has_abc){					
					for (Element aff_li : aff_lis){
						String aff_abc = aff_li.getElementsByTag("sup").first().text();
						String aff_unit = aff_li.getElementsByTag("span").first().text();
						affMap.put(aff_abc, aff_unit);
					}
				}
				else{
					for (Element aff_li : aff_lis){
						System.out.println(aff_li.text());
						affs.add(aff_li.text());
					}
				}
			}
			//输出测试
			for (int i = 0; i < authors.size(); i ++){
				System.out.println(authors.get(i));
				System.out.println(emails.get(i));
			}
			
			if (has_abc){
				Set<Map.Entry<String, String>> setAuthor = authorMap.entrySet();
		        for (Iterator<Map.Entry<String, String>> it = setAuthor.iterator(); it.hasNext();) {
		            Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
		            System.out.println(entry.getKey() + "--->" + entry.getValue());
		        }
		        
		        Set<Map.Entry<String, String>> setAff = affMap.entrySet();
		        for (Iterator<Map.Entry<String, String>> it = setAff.iterator(); it.hasNext();){
		        	Map.Entry<String, String> entry = (Map.Entry<String, String>) it.next();
		        	System.out.println(entry.getKey() + "--->" + entry.getValue());
		        }
			}
			else{
				for (int i = 0; i < affs.size(); i ++)
					System.out.println(affs.get(i));
			}
			
		}catch(Exception e ){
			e.printStackTrace();
		}
	} 
}
