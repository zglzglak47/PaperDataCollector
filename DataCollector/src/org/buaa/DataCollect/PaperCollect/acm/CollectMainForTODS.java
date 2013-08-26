package org.buaa.DataCollect.PaperCollect.acm;

/**
 * TODS 2012 please remove those //
 * @author jackland_lab
 *
 */
public class CollectMainForTODS {

	
	public static void main(String args[]){
		CollectController cc= new CollectController("TODS","ACM");

//		cc.setUrl("http://dl.acm.org/citation.cfm?doid=2109196.2109197");
		cc.setBaseUrl("http://dl.acm.org/");
//		cc.parse();
		
		//volume 37 issue4  2389241.2389242-51
		for (int i=43;i<=51;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2389241.23892"+i);
			cc.parse();
		}
		
		//volume 37 issue3  2338626.2338628 - 2338626.2338633
		for (int i=28;i<=33;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2338626.23386"+i);
			cc.parse();
		}
		
		//volume 37 issue2 2188349.2188350 - 2188349.2188357
		for (int i=50;i<=57;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2188349.21883"+i);
			cc.parse();
		}
		
		//Volume 37 Issue 1, February 2012 2109196.2109197 - 2109196.2109203
		for (int i=197;i<=203;i++){
			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2109196.2109"+i);
			cc.parse();
		}
	}
}
