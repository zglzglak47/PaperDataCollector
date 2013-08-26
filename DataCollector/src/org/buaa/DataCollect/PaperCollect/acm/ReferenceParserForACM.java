package org.buaa.DataCollect.PaperCollect.acm;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.buaa.DataCollect.database.DBHelper;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;



/**
 * 处理reference的解析类，传入一个paperId ， 和reference的URL，然后连接网络解析，然后在这里面存入数据库去
 * @author jackland_lab
 *
 */
public class ReferenceParserForACM {
	
	String baseUrl = "http://dl.acm.org/";
	
	ReferenceParserForACM(){
		
	}
	
	/**
	 * 解析Reference 需要传入helper的句柄
	 * @param helper
	 * @param paperId
	 * @param subUrl
	 * @return
	 */
	protected boolean parseReference(DBHelper helper,String paperId , String subUrl){
		
		String url = baseUrl + subUrl;
		
		try{
			Document doc = Jsoup.connect(url).
			userAgent("Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.31 (KHTML, like Gecko) Chrome/26.0.1410.64 Safari/537.31").
			get();
			
			Element tbody = doc.getElementsByTag("tbody").first();
			Elements trs = tbody.getElementsByTag("tr");
			
			for (Element tr : trs) {

				String ref = tr.text().trim();;
				System.out.println("");
				List<String> author = new ArrayList<String>();
				author.add("liushukai");
				author.add("zhaocaibei");
				author.add("zhangshuo");
				author.add("zhangxing");
				
				
				helper.addReference(paperId, ref, author, ""); 
				
 			}
			
			
		}catch(Exception e){
			
		}

		return true;
	}
	
	
}
