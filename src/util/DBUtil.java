package util;


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
		Connection conn = null;

		try {
			Properties prop = new Properties();

			// ⭐ db.properties 불러오기 (NPE 안나는 방식)
			InputStream input = DBUtil.class.getClassLoader().getResourceAsStream("util/db.properties");
			if (input == null) {
				System.out.println("db.properties 파일을 불러올 수 없습니다!");
				return null;
			}
			prop.load(input);

			String driver = prop.getProperty("driver");
			String url = prop.getProperty("url");
			String id = prop.getProperty("username");
			String pw = prop.getProperty("password");

			Class.forName(driver);
			conn = DriverManager.getConnection(url, id, pw);

		} catch (Exception e) {
			System.out.println("DB 연결 실패!");
			e.printStackTrace();
		}
		return conn;
	}

	public static void dbDisconnect(Connection conn, Statement stmt, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (stmt != null)
				stmt.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
}

