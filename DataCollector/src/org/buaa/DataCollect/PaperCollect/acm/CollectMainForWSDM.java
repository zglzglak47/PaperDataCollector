package org.buaa.DataCollect.PaperCollect.acm;

import java.util.List;

/**
 * TODS 2012 please remove those //
 * @author jackland_lab
 *
 */
public class CollectMainForWSDM {

	
	public static void main(String args[]){
		CollectController cc= new CollectController("WSDM","ACM");

//		cc.setUrl("http://dl.acm.org/citation.cfm?doid=2109196.2109197");
		cc.setBaseUrl("http://dl.acm.org/");
//		cc.parse();
		
		String  conferenceUrl = "http://dl.acm.org/tab_about.cfm?id=2124295&type=proceeding&parent_id=2124295&parent_type=proceeding&title=Proceedings%20of%20the%20fifth%20ACM%20international%20conference%20on%20Web%20search%20and%20data%20mining&toctitle=Fifth%20ACM%20International%20Conference%20on%20Web%20Search%20and%20Data%20Mining&tocissue_date=&notoc=0&usebody=tabbody&tocnext_id=&tocnext_str=&tocprev_id=&tocprev_str=&toctype=conference&cfid=350880142&cftoken=97480502";
		
		
		List<String> citationList = DetailInfoExtractor.getArnumbers(conferenceUrl);
		for (int k=0;k<citationList.size();k++){
			cc.setUrl("http://dl.acm.org/"+citationList.get(k));
			cc.parse();
		}
		
//		//下面是按具体类区分的，都包含在上边了
//		
//		//Research session a1: page rank and social networks
//		//2339530.2339537  2339530.2339541		
//		for (int i=37;i<=41;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Research session a2: pattern mining			
//		//2339530.2339543  2339530.2339547
//		for (int i=43;i<=47;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Research session a3: probabilistic models
//		//2339530.2339549  2339530.2339553
//		for (int i=49;i<=53;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Research session a4: supervised learning
//		//2339530.2339555  2339530.2339559
//		for (int i=55;i<=59;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Industry/govt track a5: mobile computing
//		//2339530.2339561  2339530.2339564
//		for (int i=61;i<=64;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Asia-Pacific track a6: session 1
//		//2339530.2339566 2339530.2339569
//		for (int i=66;i<=69;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Research session b1: social opinions
//		//2339530.2339571  2339530.2339574
//		for (int i=71;i<=74;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Research session b2: time series
//		//2339530.2339576 2339530.2339579
//		for (int i=76;i<=79;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Research session b3: matrices and tensors
//		//2339530.2339581  2339530.2339584
//		for (int i=81;i<=84;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Research session b4: unsupervised learning
//		//2339530.2339586 2339530.2339589
//		for (int i=86;i<=89;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		// Industry/govt track b5: social network analysis
//		//2339530.2339591  2339530.2339594
//		for (int i=91;i<=94;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		// Industrial practice expo b6: session 1
//		//2339530.2339596 - 97
//		for (int i=96;i<=97;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.23395"+i);
//			cc.parse();
//		}
//		
//		//Research session c1: social and web mining applications
//		//2339530.2339599 2339530.2339602
//		for (int i=599;i<=602;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.2339"+i);
//			cc.parse();
//		}
//		
//		//Research session c2: event mining
//		//2339530.2339604  2339530.2339607
//		for (int i=604;i<=607;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.2339"+i);
//			cc.parse();
//		}
//		
//		//Research session c3: matrix approximation
//		//2339530.2339609   2339530.2339612
//		for (int i=609;i<=612;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.2339"+i);
//			cc.parse();
//		}
//		
//		//Research session c4: supervised learning with multivariate data
//		//2339530.2339614   2339530.2339617
//		for (int i=614;i<=617;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.2339"+i);
//			cc.parse();
//		}
//		
//		//Industry/govt track c5: web applications
//		//2339530.2339619  - 2339530.2339622
//		for (int i=619;i<=622;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.2339"+i);
//			cc.parse();
//		}
//		
//		// Industrial practice expo c6: session 2
//		//2339530.2339624 - 25
//		for (int i=624;i<=625;i++){
//			cc.setUrl("http://dl.acm.org/citation.cfm?doid=2339530.2339"+i);
//			cc.parse();
//		}
//		
		
		
	}
}
