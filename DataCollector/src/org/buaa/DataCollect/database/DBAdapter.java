package org.buaa.DataCollect.database;
import java.sql.*;

/**
 * 数据库连接类
 * @author ZhuGengliang
 *
 */
public class DBAdapter {

	// 驱动程序�?
    String driver = "com.mysql.jdbc.Driver";

    // URL指向要访问的数据库名scutcs
    String url = "jdbc:mysql://127.0.0.1:3306/buaapaper";
	
    // MySQL配置时的用户�?
    String user = "zgl"; 

    // MySQL配置时的密码
    String password = "111111";
    
    //数据库连接对象句�?
    Connection conn;
    
	public DBAdapter() {
		// TODO Auto-generated constructor stub
		try { 
            // 加载驱动程序
            Class.forName(driver);

            // 连续数据�?
            conn = DriverManager.getConnection(url, user, password);

            if(!conn.isClosed()) 
             System.out.println("Succeeded connecting to the Database!");

		} catch(ClassNotFoundException e) {


            System.out.println("Sorry,can`t find the Driver!"); 
            e.printStackTrace();


        } catch(Exception e) {
        	e.printStackTrace();

        }
	}	
	
	public Connection getConnection(){
		return conn;
	}
	
    public ResultSet execute(String sql){
    	
    	try{
	
            // statement用来执行SQL语句
            Statement statement = conn.createStatement();

//            // 要执行的SQL语句
//            String sql = "select * from student";

            // 结果�?
            ResultSet rs = statement.executeQuery(sql);

           
            return rs;
            
    	}
            catch(SQLException e) {
              e.printStackTrace();
              return null;
           } catch(Exception e) {
              e.printStackTrace();
              return null;
           } 
	
	}

	
    public void closeDB(){
    	try {
			conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }


    
//    System.out.println("-----------------");
//    System.out.println("执行结果如下�?��:");
//    System.out.println("-----------------");
//    System.out.println(" 学号" + "\t" + " 姓名");
//    System.out.println("-----------------");
//
//    String name = null;
//
//    while(rs.next()) {
//
//     // 选择sname这列数据
//     name = rs.getString("sname");
//
//     // 首先使用ISO-8859-1字符集将name解码为字节序列并将结果存储新的字节数组中�?
//     // 然后使用GB2312字符集解码指定的字节数组
//     name = new String(name.getBytes("ISO-8859-1"),"GB2312");
//
//     // 输出结果
//     System.out.println(rs.getString("sno") + "\t" + name);
//    }
//
//    rs.close();


}