package org.buaa.DataCollect.PaperCollect.acm;

/**
 * TODS 2012 please remove those //
 * @author jackland_lab
 *
 */
public class CollectMainForTKDD {

	
	public static void main(String args[]){
		CollectController cc= new CollectController("TKDD","ACM");

//		cc.setUrl("http://dl.acm.org/citation.cfm?doid=2109196.2109197");
		cc.setBaseUrl("http://dl.acm.org/");
//		cc.parse();
		
		//Volume 5 Issue 4, February 2012  2086737.2086739-2086737.2086744
		for (int i=39;i<=44;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2086737.20867"+i);
			cc.parse();
		}
		
		//Volume 6 Issue 1, March 2012  2133360.2133361 - 2133360.2133364
		for (int i=61;i<=64;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2133360.21333"+i);
			cc.parse();
		}
		
		//Volume 6 Issue 2, July 2012 2297456.2297457 - 2297456.2297461
		for (int i=57;i<=61;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2297456.22974"+i);
			cc.parse();
		}
		
		//Volume 6 Issue 3, October 2012 2362383.2362384 -2362383.2362387
		for (int i=84;i<=87;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2362383.23623"+i);
			cc.parse();
		}
		
		//Volume 6 Issue 4, December 2012 2382577.2382579 2382577.2382583
		for (int i=79;i<=83;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2382577.23825"+i);
			cc.parse();
		}
		
	}
}
