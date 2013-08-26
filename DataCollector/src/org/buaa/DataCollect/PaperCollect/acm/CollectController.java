package org.buaa.DataCollect.PaperCollect.acm;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.buaa.DataCollect.database.DBHelper;

public class CollectController {
	String url="http://dl.acm.org/citation.cfm?doid=2389241.2389245";
	String baseUrl = "http://dl.acm.org/";
	
	
	List<String> subUrl;
	DetailURlExtractor due;
	DBHelper helper;
	
	String cgname,publisherName;
	
	public CollectController(String cgname , String publisherName){
		helper = new DBHelper();
		this.cgname = cgname;
		this.publisherName =publisherName;
	}
	
	public void parse(){
		
		try{
			
		
			due = new DetailURlExtractor(url);
			subUrl = due.getSubUrlList();  //解析子地址
			
			String authorUrl="";
			String abstractUrl="";
			String referenceUrl="";
			
			for (int i=0;i<subUrl.size();i++){
				if (subUrl.get(i).startsWith("tab_abstract")){
					abstractUrl  = subUrl.get(i);
				}
				
				if (subUrl.get(i).startsWith("tab_authors")){
					authorUrl  = subUrl.get(i);
				}

				if (subUrl.get(i).startsWith("tab_references")){
					referenceUrl  = subUrl.get(i);
				}

		

			}
			
//			checkDatainConsole();
			String mAbstract = DetailInfoExtractor.getAbstract(baseUrl+subUrl.get(0));
//			checkValueinConsole(mAbstract,"abs");
			
//			List<Map<String,String>> authors = DetailInfoExtractor.getAuthor(baseUrl+subUrl.get(1));
			List<Map<String,String>> authors = DetailInfoExtractor.getAuthorAndUnit(url);
			

			checkValueinConsole(due.getTitle(),"title");
			checkValueinConsole(authors.toString(),"author");
			
			
			if (mAbstract.compareTo("error")==0|
					authors.isEmpty()){
//				forgive this uncomplete data
			}else{
				//添加入数据库（author会自动添加）
				helper.addPaper(due.getTitle(), mAbstract, authors, null, 
						2012, publisherName, 1, cgname, referenceUrl);
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
