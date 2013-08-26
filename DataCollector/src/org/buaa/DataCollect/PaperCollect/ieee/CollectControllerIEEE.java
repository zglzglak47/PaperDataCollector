package org.buaa.DataCollect.PaperCollect.ieee;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.buaa.DataCollect.database.DBHelper;

public class CollectControllerIEEE {
	String url="http://dl.acm.org/citation.cfm?doid=2389241.2389245";
	String baseUrl = "http://dl.acm.org/";
	
	
	List<String> subUrl;
	DetailURlExtractorIEEE due;
	DBHelper helper;
	
	String cgname,publisherName;
	
	public CollectControllerIEEE(String cgname , String publisherName){
		helper = new DBHelper();
		this.cgname = cgname;
		this.publisherName =publisherName;
	}
	
	public void parse(){
		
		try{
			
			
//			due = new DetailURlExtractorIEEE(url);
//			subUrl = due.getSubUrlList();  //解析子地址

			subUrl = new ArrayList<String>();
			subUrl.add("articleDetails.jsp");  		//0
			subUrl.add("abstractAuthors.jsp");  	//1
			subUrl.add("abstractReferences.jsp");  	//2
			subUrl.add("abstractKeywords.jsp");  	//3
		
			
			
//			checkDatainConsole();
			
			/**
			 * get abstract
			 */
			String mAbstract = DetailInfoExtractorIEEE.getAbstract(baseUrl+subUrl.get(0)+url);
			checkValueinConsole(mAbstract,"abs");
			
			
			/**
			 * get author
			 */
//			List<Map<String,String>> authors = DetailInfoExtractor.getAuthor(baseUrl+subUrl.get(1));
			List<Map<String,String>> authors = 
					DetailInfoExtractorIEEE.getAuthorAndUnit(baseUrl+subUrl.get(1)+url);
			
			checkValueinConsole(authors.toString(),"author");
			
			String mTitle = DetailInfoExtractorIEEE.getTitle(baseUrl+subUrl.get(0)+url);
			checkValueinConsole(mTitle,"title");
			
			List<String> keyword = DetailInfoExtractorIEEE.getKeyword(baseUrl+subUrl.get(3)+url);
			StringBuffer sb = new StringBuffer("");
			for (int i=0;i<keyword.size();i++){
				sb.append(keyword.get(i));
				sb.append(",");
				if (i==3)break;
			}
			String key = sb.toString().trim();
			checkValueinConsole(key,"keyword");
			
			if (mTitle.compareTo("error")==0|mAbstract.compareTo("error")==0|
					authors.isEmpty()|keyword.isEmpty()){
//				forgive this uncomplete data
			}else{
				//添加入数据库（author会自动添加）
//				helper.addPaper(mTitle, mAbstract, authors, null, 
//						2012, publisherName, 1, cgname, baseUrl+subUrl.get(2)+url);
			}
			

	
		}catch(Exception e){
			e.printStackTrace();
		}
	}
	
	

	
	
	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getBaseUrl() {
		return baseUrl;
	}

	public void setBaseUrl(String baseUrl) {
		this.baseUrl = baseUrl;
	}

	/* 以下为console输出用的测试函数*/
	public void checkDatainConsole(){
		if (subUrl==null){System.out.print("fail To get subUrl"); return;}
		for(int i=0;i<subUrl.size();i++){
			System.out.println(i+" : "+subUrl.get(i));
		}
	}
	
	public void checkValueinConsole(String value,String tag){
		if (tag!=null){
			System.out.print(tag+":");
		}
		System.out.println(value);
	}
	
	
	
}
