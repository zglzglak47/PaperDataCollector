//package org.buaa.DataCollect.PaperCollect.examples;
//import java.io.IOException;
//import java.text.ParseException;
//import java.text.SimpleDateFormat;
//import java.util.ArrayList;
//import java.util.Date;
//import java.util.List;
//import java.util.Map;
//
//
//import org.jsoup.Jsoup;
//import org.jsoup.nodes.Document;
//import org.jsoup.nodes.Element;
//import org.jsoup.select.Elements;
//
//import DataVitalization.BuaaBodyTextDivider;
//import DataVitalization.BuaaIndividualBuilder;
//import DataVitalization.DVEntities.DVIndividual;
//import DataVitalization.DVEntities.DVOntology;
//import DataVitalization.DVEntities.DVProperty;
//import DataVitalization.DVOwlIO.BuaaOWLFile;
//import DataVitalization.DVOwlIO.BuaaOWLIndividualWriter;
//import DataVitalization.DVOwlIO.BuaaOWLOntoReader;
//import HotpotMining.Config.Configure;
//import HotpotMining.Models.HotPoint;
//import HotpotMining.Models.JamActivity;
//import HotpotMining.System.RuntimeData;
//import HotpotMining.Utils.GetLatLng;
//import HotpotMining.Utils.TimeUtil;
//
//
//
//
///**	对于吉祥票务网页活动信息做热点发现的挖掘�?
// * @author ZhuGengliang
// *
// */
//
//
//public class LuckyTicketPageMiner {
//	
//	public static final String SHOW="演出活动";
//	public static final String GAME="体育比赛";
//	public static final String EXIBITION="会展活动";
//	public static final String defaultTime=" 19:30:00";
//	public static final int defaultLimitSpan=1000;
//	
//	
////service httpd start	
//
//	public  Elements infos;
//	
//	public  String[] infoText;
//	
//	public  List<HotPoint> pointlist;
//	
//	public  List<JamActivity> activitylist;
//	
//	
//	public LuckyTicketPageMiner(){
//		pointlist = new ArrayList<HotPoint>();
//	}
//	
//	/**
//	 * @param args
//	 */
//	public void runForJamActivity() {
//		// TODO Auto-generated method stub
//		
//		activitylist = new ArrayList<JamActivity>();
//		
//		Document doc;
//		int counter = 0;
//		try {
////			
//			doc = Jsoup.connect(Configure.LuckyTicketActivityInfoURL).get();
//			
//			
//			//分析内容，获得活动列�?
//			parseJamActivity(doc,"3");  //演唱�?
//			parseJamActivity(doc,"4");	//古典音乐
//			
//
//			//解析成热�?
//			makeHotPoints();
//			
//			for (int i=0;i<pointlist.size();i++){
//				RuntimeData.addHotPoint(pointlist.get(i));
//			}
//			
//			//打印热点
//			printAllHotPoint();
//
//		
//			
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			System.out.println("票务网站解析出错�?);
//		}
//		
//		
//		
//		
//	}
//	
//	
//	/**
//	 * 识别吉祥票务网中�?��类型活动的HTML列表
//	 * 其结果会添加到activitylist�?
//	 * @param doc 网页的Jsoup的doc句柄 
//	 * @param id  解析的表格对应的id字符�?
//	 * 3是演唱会 �?4 是古典音�?，以此类�?
//	 */
//	 void parseJamActivity(Document doc , String id){
//		Element concertTable = doc.select("table[id="+id+"]").first();
////		System.out.println("concertTable Text :" +concertTable.text());
//
//		Element bigTd = concertTable.select("td[bgcolor=#cccccc]").first();
////		System.out.println("bigTd Text :" +bigTd.text());
//		
//		Elements items = bigTd.select("tr[onmouseover=this.bgColor='#EDEFF1']");
////		System.out.println("item Text :" +item.text());
//		
//		for (int i=0;i<items.size();i++){
//			
//			Element e =  items.get(i);
//			Elements tds = e.select("td");
//			JamActivity ac = new JamActivity();
//			ac.setTitle(tds.get(0).text());
//			ac.setTime(tds.get(1).text());
//			ac.setAddress(tds.get(2).text());
//			ac.setType(JamActivity.getTypeCode(SHOW));
////			System.out.println(ac.toString());
//			if (ac.getAddress().indexOf("五棵�?)>=0)ac.setAddress("五棵松体育馆");
//			//if (ac.getAddress().indexOf("国家大剧�?)>=0)ac.setAddress("北京市西城区西长安街2�?);
//			
//			
//			activitylist.add(ac);
//		}
//	}
//	 
//	 /**
//	  * 将目前activitylist中的活动转换成list
//	  */
//	 void makeHotPoints(){
//		 
//		 String location;
//		 
//		 for (int i=0;i<activitylist.size();i++){
//			 JamActivity ac = activitylist.get(i);
//			 String time = ac.getTime().substring(0, 10);
////				System.out.println(time);
//				
//				SimpleDateFormat format = new SimpleDateFormat("yyyy.MM.dd hh:mm:ss");
//				Date eventDate = new Date(324242);
//				try {
//					 eventDate = format.parse(time+defaultTime);
//				} catch (ParseException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				Date today = new Date();
//				float hour_dis =(float)(eventDate.getTime() - today.getTime())/(1000*60*60);
//				//活动时间不能�?个小时前发生了，或�?48小时以后才发生的
////				System.out.println(time+"  ");
////				System.out.println(hour_dis+"");
//				if (hour_dis>-3 && hour_dis<defaultLimitSpan){
//					
//					//解析地址，地�?��析不了还是不添加
//					GetLatLng geo = new GetLatLng();
//					try {
//						String tmp = ac.getAddress();
//						if (tmp.indexOf("国家大剧�?)>=0)tmp="北京市西城区西长安街2�?;
//						
//						location  = geo.getLocation(tmp);
////						System.out.println(ac.getAddress()+":"+location);
//						
//						
//					}catch (Exception e ){
//						location = null;
//					}
//					
//					if (location!=null && ac.getAddress().length()>1){
//					
//					
//						HotPoint hp = new HotPoint();
//						String tmp[] = location.split(",");
//						hp.setLat(tmp[0]);
//						hp.setLon(tmp[1]);
//						hp.setAddress(ac.getAddress());
//						hp.setType("3");
//						hp.setEvent(ac.getTitle());
//						hp.setSpan(8000);
//						hp.setLevel((int)(System.currentTimeMillis()%3+1));
//						hp.setTime(TimeUtil.formatDate(eventDate));
//						hp.setDescription("none");
//						hp.setStoringtime((int)(System.currentTimeMillis()/1000));
//						hp.setPointID(TimeUtil.getNewId());
//						pointlist.add(hp);
//
//					}
//				}
//		 }
//	 }
//	 
//	 void printAllHotPoint(){
//		for (int i=0;i<pointlist.size();i++){
//			
//			System.out.println(pointlist.get(i).getEvent());
//			System.out.println(pointlist.get(i).toJson());
//			
//		}
//		 
//	 }
//	 
//	
//	
//
//
//	public static void main(String[] args) {
//		new LuckyTicketPageMiner().runForJamActivity();
//	}
//	
//	
//	
//
//}


