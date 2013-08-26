package org.buaa.DataCollect.PaperCollect.ors;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TestEJIS {

	public static void main(String[] args) {
		File input = new File("F:\\gz\\Data\\html\\European Journal of Information Systems - Abstract of article  Towards the improved treatment of generalization of knowledge claims in IS research  drawing general conclusions from samples.htm");
		try {
//			Document doc = Jsoup.parse(input, "UTF-8", "http://link.springer.com/article/");
			Document doc = Jsoup.connect("http://www.palgrave-journals.com/ejis/journal/v21/n2/abs/ejis201150a.html").
					userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
					get();
			
			//title
			String title = doc.getElementById("atl").text();
			
			//abstract
			Element eAbs = doc.getElementById("abs");
			String abst = eAbs.getElementsByTag("p").first().text();
			System.out.println(abst);
			
			Elements ps = eAbs.getElementsByTag("p");
			Element pKey = null;
			for (Element p : ps){
				if (p.hasAttr("class") && p.attr("class").equals("keywords")){
					pKey = p;
					break;
				}
			}
			//keywords
			String keywords = pKey.text();
			System.out.println(keywords);
			
			//author
			Element ea = doc.getElementById("aug");
			System.out.println(ea.text());
			
			List<Map<String, String>> authors = new ArrayList<Map<String, String>>();
			Map<String, String> supAuthor = new HashMap<String, String>();
			Map<String, String> supAffi = new HashMap<String, String>();
			
			Pattern pattern = Pattern.compile("[^\\d]+\\d(?=\\D|$)");
			Matcher matcher = pattern.matcher(ea.text());
			while(matcher.find()){
				String s = matcher.group();
				String name = s.substring(0, s.length() - 1).replace(", ", "").replace(" and ", "").trim();
				String sup = s.substring(s.length() -1, s.length());
				supAuthor.put(sup, name);
				System.out.println(name + "------" + sup);
			}
			//author names and tags
			Element divAf = doc.getElementById("affiliations-notes");
			Elements liAf = divAf.getElementsByTag("li");
			for (Element li : liAf){
				String s = li.text();
				String supAf = s.substring(0, 1);
				String affi = s.substring(1);
				System.out.println(supAf + "------" + affi);
				supAffi.put(supAf, affi);
			}
			//author units and tags
			Element p = null;
			for (Element e : divAf.getElementsByTag("p")){
				if (e.hasAttr("class") && e.attr("class").equals("caff")){
					p = e;
					break;
				}
			}
			//author name and email
			String emailTxt = p.text();
			String emailName = emailTxt.substring(emailTxt.indexOf(":") + 2, emailTxt.indexOf(",")).replace(".", "");
			System.out.println("EM: "+emailName);
			String email = p.getElementsByTag("a").first().text();
			System.out.println(email);
			
			Set<Map.Entry<String, String>> set = supAuthor.entrySet();
			for (Iterator<Map.Entry<String, String>> it = set.iterator(); it.hasNext();){
				Map<String, String> map = new HashMap<String, String>();
				
				Map.Entry<String, String> entry = it.next();
				String name = entry.getValue().toString();
				
				map.put("name", name);
				map.put("unit", supAffi.get(entry.getKey()));
				if (emailName.compareTo(name) == 0)
					map.put("email", email);
				else{
					map.put("email", null);

					String a = new String(emailName.trim().getBytes("UTF-8"),"UTF-8");
					String b = new String(name.trim().getBytes("UTF-8"),"UTF-8");
					a = a.replaceAll("'", "");
					b = b.replaceAll("'", "");
					a = a.replaceAll(" ", "");
					b = b.replaceAll(" ", "");
					
					
					System.out.println(a+":"+b+"|"+a.compareTo(b));
					byte[] aa = a.getBytes();
					byte[] bb = b.getBytes();
					for (int i=0;i<aa.length;i++){
						System.out.print(aa[i]+",");
					}
					System.out.println();
					for (int i=0;i<bb.length;i++){
						System.out.print(bb[i]+",");
					}
					
					
					System.out.println("compare:"+emailName + "----" + name+emailName.compareTo(name.toLowerCase()));    //神马不同？？？？？？？
					System.out.println("test:"+("Robert M O'Keefe".compareTo("Robert M O'Keefe")));    //神马不同？？？？？？？

				}
					map.put("telephone", null);
				map.put("address", null);
				authors.add(map);
			}
			//print list
			System.out.println("------------------");
			Iterator<Map<String, String>> iter1 = authors.iterator();
			while(iter1.hasNext()){
				Map<String, String> temp = iter1.next();
				Set<Map.Entry<String, String>> set1 = temp.entrySet();
				Iterator<Map.Entry<String, String>> iter2 = set1.iterator();
				while(iter2.hasNext()){
					Map.Entry<String, String> entry2 = iter2.next();
					System.out.println(entry2.getKey() + "----" + entry2.getValue());
				}
				System.out.println("----------------------------------------");
			}
			
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}
