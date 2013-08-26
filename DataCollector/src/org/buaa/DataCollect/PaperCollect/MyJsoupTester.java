package org.buaa.DataCollect.PaperCollect;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;


import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;


public class MyJsoupTester {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Document doc;
		try {
//			doc = Jsoup.connect("http://news.qq.com/a/20121221/001936.htm").get();
	
			//百度百科 ，狮子
			//doc = Jsoup.connect("http://baike.baidu.com/view/17211.htm").get();
			
			//百度百科 , 北京
//			doc = Jsoup.connect("http://baike.baidu.com/view/2621.htm").get();
			
			doc = Jsoup.connect("http://cbachina.sports.sohu.com/20121203/n359279358.shtml").get();
			//doc = Jsoup.connect("http://news.163.com/12/1203/03/8HP4D9MF00014AED.html").get();
			
			String title = doc.title();
			Element body = doc.body();
			
			System.out.println("title  :" + title);
			System.out.println("body text :" + body.text());
			//System.out.println("body ownText :" + body.ownText());
			//System.out.println("body data :" + body.data());
			//System.out.println("body html :" + body.outerHtml());
			
//			for (int i=0;i<list.size();i++)
//			{
//				System.out.println("词汇：" +  list.get(i).get(divider.WORD)
//						+"          词性：" +  list.get(i).get(divider.TYPE)
//						);
//
//			}
			
//		    ArrayList<MidResult> mrlist = sr.getMrList();
//		    //sr.
//			
//		    for (int i=0;i<mrlist.size();i++)
//		    {
//		    	MidResult mr = mrlist.get(i);
////		    	System.out.println("MR to html：" + mr.toHTML());
////		    	System.out.println("MR to string：" + mr.toString());
//		    	
//			    
//		    }
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
