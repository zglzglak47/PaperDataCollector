package org.buaa.DataCollect.PaperCollect.test;
import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class Test {
	public static void main(String args[]){
		Test T = new Test();
		T.parseUrl("http://www.baidu.com/");
	}
	
	public void parseUrl(String url){
		Document doc;
		try {
			doc = Jsoup.connect(url).get();
			Elements hrefs = doc.select("a[href]");
			System.out.println("--------------------");
			System.out.println(hrefs.select("[href^=http]"));
			System.out.println("--------------------");
			//Element content = doc.getElementById("content");
			/*Element m = doc.getElementById("m");
			Elements imgs = m.getElementsByTag("img");
			for (Element img : imgs){
				System.out.println(img.attr("width") + '\n');
				System.out.println(img.attr("height") + '\n');
			}*/
			Elements divs = doc.getElementsByTag("div");
			for(Element div : divs){
				System.out.println(div.attr("id") + '\n');
				System.out.println(div.text() + '\n');
			}
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}
