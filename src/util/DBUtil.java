package util;

//package com.shinhan.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class DBUtil {

	public static Connection dbConnect() {	
		Connection conn=null;
			
		Properties pro = new Properties();
		String path = "oracleAhpdb.properties";
		
		InputStream is = DBUtil.class.getResourceAsStream(path);
		try {
			pro.load(is);
			String driver = pro.getProperty("driver");
			//System.out.println(driver);
			String url = pro.getProperty("url");    //"jdbc:oracle:thin:@//localhost:1521/MYPDB";
			//System.out.println(url);
			String id = pro.getProperty("username"); //"ah";
			String pass = pro.getProperty("password");//"ah";		
			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pass);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}


	public static void dbDisconnect(Connection conn, Statement st, ResultSet rs) {
		try {
			if(rs!=null) rs.close();
			if(st!=null) st.close();
			if(conn!=null) conn.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
	}
	
}

