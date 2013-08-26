package org.buaa.DataCollect.PaperCollect.ieee;

import java.util.List;

/**
 * TODS 2012 please remove those //
 * @author jackland_lab
 *
 */
public class CollectMainIEEEForTKDE {

	
	public static void main(String args[]){
		CollectControllerIEEE cc= new CollectControllerIEEE("TKDE","IEEE");

//		cc.setUrl("?arnumber=6228066");   //the dot numer
		cc.setBaseUrl("http://ieeexplore.ieee.org/xpl/");  //plus the url to the tail of baseurl
//		cc.parse();
		
				

		
		List<String> arnumbers;
		
//		Knowledge and Data Engineering, IEEE Transactions on
//		Issue 1 • Date Jan. 2012 5959167 5674040 5611523  5645617
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6084775&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
//		Issue 2 • Date Feb. 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6108378&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		issue 3 • Date March 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6138960&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		Issue 4 • Date April 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6156881&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		Issue 5 • Date May 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6174514&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		Issue 6 • Date June 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6188607&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		Issue 7 • Date July 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6203536&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		Issue 8 • Date Aug. 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6226556&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		Issue 9 • Date Sept. 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6247403&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		Issue 10 • Date Oct. 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6272287&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		Issue 11 • Date Nov. 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6308678&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
//		Issue 12 • Date Dec. 2012
		arnumbers = DetailInfoExtractorIEEE.
				getArnumbers("http://ieeexplore.ieee.org/xpl/tocresult.jsp?isnumber=6335084&punumber=69");
		for (int i=0;i<arnumbers.size();i++){
			cc.setUrl("?"+arnumbers.get(i));   //the dot numer
			cc.parse();
		}
		
		
		

		
	}
}
