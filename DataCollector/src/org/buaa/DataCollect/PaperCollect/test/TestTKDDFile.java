package org.buaa.DataCollect.PaperCollect.test;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestTKDDFile {

	public static void main(String[] args) {
		File input = new File("F:\\gz\\Data\\html\\Guest Editorial for Special Issue KDD��10.htm");
		try {
			Document doc = Jsoup.parse(input, "UTF-8", "http://dl.acm.org/");
			String title = doc.title();
			System.out.println(title + '\n');
			Elements script = doc.getElementsByTag("script");
			Pattern pattern = Pattern.compile("tab_[0-9a-zA-Z./?&=_]*'");  //tab_[\w-./?%&=]*\'\]\}
			//Pattern pattern = Pattern.compile("tab_[\\w-./?%&=]*\\'\\]\\}");
			Matcher matcher = pattern.matcher(script.html());
			//System.out.println(matcher.find());
			List<String> tab_urls = new ArrayList<String>();
			while(matcher.find()){
				String s = matcher.group();
				String sub = s.substring(0, s.length()-1);
				tab_urls.add(sub);
				//System.out.println(sub);				
			}
			//System.out.println('\n');
			/*for(int i = 0; i < tab_urls.size(); i ++){
				String url = "http://dl.acm.org/" + tab_urls.get(i);
				Document sub_doc = Jsoup.connect(url).
						userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
						get();
				System.out.println(sub_doc.text());
				System.out.println('\n');
			}
			*/
			String url = "http://dl.acm.org/" + tab_urls.get(2);
			System.out.println(url);
			Document sub_doc = Jsoup.connect(url).
					userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
					get();
			if(sub_doc.text().equals("An abstract is not available.")){
				System.out.println("sorry, abstract is not available.");
			}
			else{
				System.out.println(doc.text());
			}
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
