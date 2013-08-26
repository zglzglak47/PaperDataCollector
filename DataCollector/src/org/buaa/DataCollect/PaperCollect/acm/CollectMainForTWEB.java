package org.buaa.DataCollect.PaperCollect.acm;

/**
 * TODS 2012 please remove those //
 * @author jackland_lab
 *
 */
public class CollectMainForTWEB {

	
	public static void main(String args[]){
		CollectController cc= new CollectController("TWEB","ACM");

//		cc.setUrl("http://dl.acm.org/citation.cfm?doid=2109196.2109197");
		cc.setBaseUrl("http://dl.acm.org/");
//		cc.parse();
		
		//Volume 6 Issue 1, March 2012  2109205.2109206 - 2109205.2109209
		for (int i=6;i<=9;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2109205.210920"+i);
			cc.parse();
		}
		
		//Volume 6 Issue 2, May 2012  2180861.2180863 - 2180861.2180866
		for (int i=63;i<=66;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2180861.21808"+i);
			cc.parse();
		}
		
		//Volume 6 Issue 3, September 2012 2344416.2344417 - 2344416.2344420
		for (int i=17;i<=20;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2344416.23444"+i);
			cc.parse();
		}
		
		//Volume 6 Issue 4, November 2012 2382616.2382617 -2382616.2382621
		for (int i=17;i<=21;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2382616.23826"+i);
			cc.parse();
		}
		
		
		
	}
}
