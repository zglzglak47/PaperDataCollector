package org.buaa.DataCollect.PaperCollect.test;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class TestTKDD {
	public static void main(String args[]){
		try{
			Document doc = Jsoup.connect("http://dl.acm.org/citation.cfm?doid=2086737.2086738").
					userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
					get();
			//����
			String title = doc.title();
			System.out.println(title + '\n');
			//Elements els = doc.getElementsByClass("medium-text");
			
			//Elements publin = doc.getElementsByAttributeValue("style", "padding-left:10px;");
			//System.out.println(publin.text());
			//System.out.println(doc.text());
			Elements script = doc.getElementsByTag("script");
			//System.out.println(script.html());
					
			//Pattern pattern = Pattern.compile("['tab_{*}]");
//			Pattern pattern = Pattern.compile("tab_([0-9]|[a-z]|[&]){*}'");
			Pattern pattern = Pattern.compile("tab_[0-9a-zA-Z./?&=_]*'");
			
			
			Matcher matcher = pattern.matcher(script.html());
			//List<String> tab_urls = new ArrayList<String>();
			System.out.println(matcher.find());
			while(matcher.find()){
				String s = matcher.group();
				//String sub = s.substring(0, s.length()-3);
				//tab_urls.add(sub);
				System.out.println(s);
				
			}
			
			/*		String str = "Test127.0.0.1Test1127.0.0.2Test111127.0.0.3Test4"; //Դ�ַ�
			  Pattern pattern = Pattern.compile("\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}\\.\\d{1,3}"); //������ʽƥ���ʽ
			  Matcher matcher = pattern.matcher(str);
			  List<String> list = new ArrayList<String>();
			  while(matcher.find())
			  {
			  String srcStr = matcher.group();    //����õ���ip
			  list.add(srcStr);          //��ƥ��Ľ�����List
			  }
			  System.out.println(list);
			  for(int i=0;i<list.size();i++){
			   System.out.println(list.get(i));
			  }		*/
					
					
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}
