package org.buaa.DataCollect.database;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;




public class DBHelper {

	
	DBAdapter dba;
	public DBHelper() {
		// TODO Auto-generated constructor stub
		dba = new DBAdapter();
	}
	
	/**
	 * add an author and return it's auto-generate id
	 * @param name
	 * @param email
	 * @param telephone
	 * @param unit
	 * @param address
	 * @return authorId
	 */
	public String addAuthor(String name,String email,String telephone,String unit,String address){
		String sql = "insert into author(name,unit,email,telephone,address) values(?,?,?,?,?)"; 
		String SelectSql = "select authorId from author where name=?";
		
		String authorId=null;
		
		PreparedStatement ps;
		PreparedStatement ps2;
		try {
			ps = dba.getConnection().prepareStatement(sql);
		
			ps.setString(1, name);
			ps.setString(2, email);
			ps.setString(3, telephone);
			ps.setString(4, unit);
			ps.setString(5, address);
			
			ps.executeUpdate();
			
			ps2 = dba.getConnection().prepareStatement(SelectSql);
			ps2.setString(1, name);
			ResultSet rs = ps2.executeQuery();
			if (rs.next()){
				authorId =rs.getInt("authorId")+"";
			}
			
			return authorId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return authorId;
		} catch (Exception e){
			e.printStackTrace();
			return authorId;
		}
	}
	
	/**
	 * check if a author name exist nor return null
	 * @param name
	 * @return
	 */
	public String getAuthorId(String name){
		String id = null;
		String SelectSql = "select authorId from author where name=?";
		PreparedStatement ps;
		PreparedStatement ps2;
		try {
			ps = dba.getConnection().prepareStatement(SelectSql);
		
			ps.setString(1, name);
			ResultSet rs = ps.executeQuery();
			if (rs.next()){
				id =rs.getInt("authorId")+"";
			}
			return id;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return id;
		} catch (Exception e){
			e.printStackTrace();
			return id;
		}
	}
	
	/**
	 * 
	 * @param title
	 * @param paperAbstract
	 * @param author
	 * @param keyword
	 * @param pubYear
	 * @param publisher
	 * @param type
	 * @param cgname
	 * @param reference
	 * @return
	 */
	public String addPaper(String title,
			String paperAbstract,
			List<Map<String,String>> author,
			String keyword,
			int pubYear,
			String publisher,
			int type,
			String cgname,
			String reference){
		String sql = "insert into paper(" +
				"title," +
				"author1," +
				"author2," +
				"author3,author4," +
				"abstract," +
				"reference," +
				"publisher," +
				"type," +
				"cgname," +
				"keyword," +
				"pubYear) " +
				"values(?,?,?,?,?,?,?,?,?,?,?,?)"; 
		String SelectSql = "select paperId from paper where title=?";
		
		String authorId=null;
		
		PreparedStatement ps;
		PreparedStatement ps2;
		try {
			ps2 = dba.getConnection().prepareStatement(SelectSql);
			ps2.setString(1, title);
			ResultSet rs = ps2.executeQuery();
			if (rs.next()){
				authorId =rs.getInt("paperId")+"";
				return authorId;
			}
			
			ps = dba.getConnection().prepareStatement(sql);
		
			ps.setString(1,title);
			
			if (author.size()>0){
				String aName = author.get(0).get("name");
				String aEmail = author.get(0).get("email");
				String aTelephone = author.get(0).get("telephone");
				String aAddress = author.get(0).get("address");
				String aUnit = author.get(0).get("unit");
				String aid =  getAuthorId(aName);
				if (aid==null){
					aid = addAuthor(aName,aEmail,aTelephone,aUnit,aAddress);
				}
				ps.setInt(2,Integer.valueOf(aid));
			}else {
				ps.setInt(2,0);
			}
			
			if (author.size()>1){
				String aName = author.get(1).get("name");
				String aEmail = author.get(1).get("email");
				String aTelephone = author.get(1).get("telephone");
				String aAddress = author.get(1).get("address");
				String aUnit = author.get(1).get("unit");
				String aid =  getAuthorId(aName);
				if (aid==null){
					aid = addAuthor(aName,aEmail,aTelephone,aUnit,aAddress);
				}
				ps.setInt(3,Integer.valueOf(aid));
			}else {
				ps.setInt(3,0);
			}
			
			if (author.size()>2){
				String aName = author.get(2).get("name");
				String aEmail = author.get(2).get("email");
				String aTelephone = author.get(2).get("telephone");
				String aAddress = author.get(2).get("address");
				String aUnit = author.get(2).get("unit");
				String aid =  getAuthorId(aName);
				if (aid==null){
					aid = addAuthor(aName,aEmail,aTelephone,aUnit,aAddress);
				}
				ps.setInt(4,Integer.valueOf(aid));
			}else {
				ps.setInt(4,0);
			}
			
			if (author.size()>3){
				String aName = author.get(3).get("name");
				String aEmail = author.get(3).get("email");
				String aTelephone = author.get(3).get("telephone");
				String aAddress = author.get(3).get("address");
				String aUnit = author.get(3).get("unit");
				String aid =  getAuthorId(aName);
				if (aid==null){
					aid = addAuthor(aName,aEmail,aTelephone,aUnit,aAddress);
				}
				ps.setInt(5,Integer.valueOf(aid));
			}else {
				ps.setInt(5,0);
			}
			
			ps.setString(6,paperAbstract);
			ps.setString(7,reference);
			ps.setString(8,publisher);
			ps.setInt(9,type);
			ps.setString(10,cgname);
			ps.setString(11,keyword);
			ps.setInt(12,pubYear);
			
			
			
			ps.executeUpdate();
			
			ps2 = dba.getConnection().prepareStatement(SelectSql);
			ps2.setString(1, title);
			 rs = ps2.executeQuery();
			if (rs.next()){
				authorId =rs.getInt("paperId")+"";
			}
			
			return authorId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return authorId;
		} catch (Exception e){
			e.printStackTrace();
			return authorId;
		}
	}
	
	
	/**
	 * 根据title选择id
	 * @param title
	 * @return
	 */
	public String getPaperIdByTitle(String title){
		String sql = "select paperId from paper where title=?";
	
		String authorId = null;
		
		PreparedStatement ps;
		try {
			ps = dba.getConnection().prepareStatement(sql);
			
			ps.executeUpdate();
			ps.setString(1, title);
			ResultSet rs = ps.executeQuery();
			
			if (rs.next()){
				authorId =rs.getInt("authorId")+"";
			}
			
			return authorId;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return authorId;
		} catch (Exception e){
			e.printStackTrace();
			return authorId;
		}
	}
	
	/**
	 * 根据title选择id
	 * @param title
	 * @return
	 */
	public List<Paper> getPaperListByPublisher(String publisher){
		List<Paper> list = new ArrayList<Paper>();
		
		String sql = "select paperId,reference from paper where publisher=?";
	
		String authorId = null;
		
		PreparedStatement ps;
		try {
			ps = dba.getConnection().prepareStatement(sql);
			
			ps.setString(1, publisher);
			ResultSet rs = ps.executeQuery();
			
			while (rs.next()){
				Paper paper = new Paper();
				paper.id = rs.getString("paperId");
				paper.reference = rs.getString("reference");
				
				list.add(paper);
			}

			
			return list;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return list;
		} catch (Exception e){
			e.printStackTrace();
			return list;
		}
	}
	
	/**
	 * 添加引用
	 * @param paperId
	 * @param title  引用的title
	 * @param author
	 * @param source
	 * @return
	 */
	public boolean addReference(String paperId,String title,List<String> author,String source){
		String sql = "insert into reference(paperId,title,author1,author2,author3,author4,source) values(?,?,?,?,?,?,?)"; 
		
		
		PreparedStatement ps;
		try {
			ps = dba.getConnection().prepareStatement(sql);
			
			int authorSize = author.size();
			String author1 = null; if (authorSize>0) author1 = author.get(0);
			String author2 = null; if (authorSize>1) author2 = author.get(1);
			String author3 = null; if (authorSize>2) author3 = author.get(2);
			String author4 = null; if (authorSize>3) author4 = author.get(3);
			
			ps.setString(1, paperId);
			ps.setString(2, title);
			ps.setString(3, author1);
			ps.setString(4, author2);
			ps.setString(5, author3);
			ps.setString(6, author4);
			ps.setString(7, source);
			
			ps.executeUpdate();
		
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} catch (Exception e){
			e.printStackTrace();
			return false;
		}
	}
		
//	public boolean addWeibo(Status s){
//		
//		String sql = "insert into weibo(info,id,latitude,longitude,user,location,time) values(?,?,?,?,?,?,?)"; 
////		String sql = "insert into weibo values(?,?,?,?,?,?)"; 
//
//		System.out.println("id : "+ s.getId());
//		
//		PreparedStatement ps;
//		try {
//			ps = dba.getConnection().prepareStatement(sql);
//		
//			ps.setString(1, s.getText());
//			ps.setString(2, s.getId());
//			ps.setString(3, s.getLatitude()+"");
//			ps.setString(4, s.getLongitude()+"");
//			ps.setString(5, s.getUser().getName());
//			ps.setString(6, s.getUser().getLocation());
//			ps.setLong(7, System.currentTimeMillis()/1000);
//			
//			ps.executeUpdate();
//			
//			return true;
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//			return false;
//		} catch (Exception e){
//			e.printStackTrace();
//			return false;
//		}
//		
//	}


}
