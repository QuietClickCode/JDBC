package cn.itcast.jdbcutil;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JDBCUtils{
	private static Connection con;
	static{
		try{
			
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/mybase";
		String username="root";
		String password="123";
		con=DriverManager.getConnection(url,username,password);
		}catch(Exception ex){
			throw new RuntimeException(ex+"数据库连接失败");
		}
	}
	public static Connection getConnection(){
		return con;
	}
	public static void close(Connection con,Statement stat,ResultSet rs){
		if(con!=null){
			try{
				con.close();
			}catch(SQLException ex){
				
			}
		}
		if(stat!=null){
			try{
				stat.close();
			}catch(SQLException ex){
				
			}
		}
		if(rs!=null){
			try{
				rs.close();
			}catch(SQLException ex){
				
			}
		}
	}
	public static void close(Connection con,Statement stat){
		if(con!=null){
			try{
				con.close();
			}catch(SQLException ex){
				
			}
		}
		if(stat!=null){
			try{
				stat.close();
			}catch(SQLException ex){
				
			}
		}
	}
}