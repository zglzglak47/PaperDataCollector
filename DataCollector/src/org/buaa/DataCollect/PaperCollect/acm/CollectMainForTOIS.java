package org.buaa.DataCollect.PaperCollect.acm;

/**
 * TODS 2012 please remove those //
 * @author jackland_lab
 *
 */
public class CollectMainForTOIS {

	
	public static void main(String args[]){
		CollectController cc= new CollectController("TOIS","ACM");

//		cc.setUrl("http://dl.acm.org/citation.cfm?doid=2109196.2109197");
		cc.setBaseUrl("http://dl.acm.org/");
//		cc.parse();
		
		//Volume 30 Issue 1, February 2012  2094072.2094073-2094072.2094078
		for (int i=73;i<=78;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2094072.20940"+i);
			cc.parse();
		}
		
		//Volume 30 Issue 2, May 2012  2180868.2180869 - 2180868.2180876
		for (int i=69;i<=76;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2180868.21808"+i);
			cc.parse();
		}
		
		//Volume 30 Issue 3, August 2012 2328967.2328968 - 2328967.2328972
		for (int i=68;i<=72;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2328967.23289"+i);
			cc.parse();
		}
		
//		Volume 30 Issue 4, November 2012 2382438.2382439 -2382438.2382446
		for (int i=39;i<=46;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2382438.23824"+i);
			cc.parse();
		}
	}
}
