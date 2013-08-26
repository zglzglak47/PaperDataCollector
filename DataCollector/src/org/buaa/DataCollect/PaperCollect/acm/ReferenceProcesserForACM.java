package org.buaa.DataCollect.PaperCollect.acm;

import java.util.List;

import org.buaa.DataCollect.database.DBHelper;
import org.buaa.DataCollect.database.Paper;
/**
 * 处理ref的控制类 ， 此处先把数据库中出版商是ACM的条目选择出来，然后处理没一条reference URL
 * @author jackland_lab
 *
 */
public class ReferenceProcesserForACM {
	public static void main(String args[]){
		
		DBHelper helper = new DBHelper();
		ReferenceParserForACM rp = new ReferenceParserForACM();
//		List<Paper> refList =  helper.getPaperListByPublisher("ACM");
//		checkRefListinConsole(refList);
		
		
		// <测试样例
//		tab_references.cfm?id=2338630&type=article&usebody=tabbody&cfid=236859742&cftoken=48999081
		rp.parseReference(helper, "10", "tab_references.cfm?id=2338630&type=article&usebody=tabbody&cfid=236859742&cftoken=48999081");
		//   测试样例结束  \>
		
//		for (int i=0;i<refList.size();i++){
//			rp.parseReference(helper, refList.get(i).getId(), refList.get(i).getReference());
//		}
		
		
	}
	
	
	
	public static void checkRefListinConsole(List<Paper> list){
		for (int i=0;i<list.size();i++){
			System.out.println(list.get(i).getId()+":"+list.get(i).getReference());
		}
	}
}
