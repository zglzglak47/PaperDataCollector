package org.buaa.DataCollect.PaperCollect.ieee;

/**
 * TODS 2012 please remove those //
 * @author jackland_lab
 *
 */
public class CollectMainIEEEForICDE {

	
	public static void main(String args[]){
		CollectControllerIEEE cc= new CollectControllerIEEE("ICDE","IEEE");

		cc.setUrl("?arnumber=6228066");   //the dot numer
		cc.setBaseUrl("http://ieeexplore.ieee.org/xpl/");  //plus the url to the tail of baseurl
		cc.parse();
		
		
		
//		Data Engineering (ICDE), 2012 IEEE 28th International Conference on
//		62228064 - 6228179
		for (int i=64;i<=179;i++){
			String number = i+"";
			if (i<100) number = "0"+i;
			cc.setUrl("?arnumber=6228"+number);   //the dot numer
			cc.parse();
		}
		
	}
}
