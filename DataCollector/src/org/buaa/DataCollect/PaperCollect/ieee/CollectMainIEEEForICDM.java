package org.buaa.DataCollect.PaperCollect.ieee;

import java.util.List;

/**
 * TODS 2012 please remove those //
 * @author jackland_lab
 *
 */
public class CollectMainIEEEForICDM {

	
	public static void main(String args[]){
		CollectControllerIEEE cc= new CollectControllerIEEE("ISWC","IEEE");

//		cc.setUrl("?arnumber=6228066");   //the dot numer
		cc.setBaseUrl("http://ieeexplore.ieee.org/xpl/");  //plus the url to the tail of baseurl
//		cc.parse();
		
				

		
		List<String> arnumbers;
		
//		Wearable Computers (ISWC), 2012 16th International Symposium on
//		page1
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/mostRecentIssue.jsp?punumber=6412852&punumber%3D6412852%26sortType%3Dasc_p_Sequence%26filter%3DAND%28p_IS_Number%3A6413715%29%26pageNumber%3D2&pageNumber=1");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		page2
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/mostRecentIssue.jsp?punumber=6412852&punumber%3D6412852%26sortType%3Dasc_p_Sequence%26filter%3DAND%28p_IS_Number%3A6413715%29&pageNumber=2");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
		http://ieeexplore.ieee.org/xpl/mostRecentIssue.jsp?punumber=6412852&punumber%3D6412852%26sortType%3Dasc_p_Sequence%26filter%3DAND%28p_IS_Number%3A6413715%29&pageNumber=3
//		page3
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/mostRecentIssue.jsp?punumber=6412852&punumber%3D6412852%26sortType%3Dasc_p_Sequence%26filter%3DAND%28p_IS_Number%3A6413715%29&pageNumber=3");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
			
//		page4
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/mostRecentIssue.jsp?punumber=6412852&punumber%3D6412852%26sortType%3Dasc_p_Sequence%26filter%3DAND%28p_IS_Number%3A6413715%29%26pageNumber%3D3&pageNumber=4");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
			
//		page5
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/mostRecentIssue.jsp?punumber=6412852&punumber%3D6412852%26sortType%3Dasc_p_Sequence%26filter%3DAND%28p_IS_Number%3A6413715%29%26pageNumber%3D4&pageNumber=5");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
		
		

		
	}
}
