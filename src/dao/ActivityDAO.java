package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import dto.ActivityDTO;

public class ActivityDAO {

	private static ActivityDAO dao = new ActivityDAO();
	private String driver;
	private String url;
	private String username;
	private String password;

	public static ActivityDAO getInstance() {
		return dao;
	}

	private ActivityDAO() {
		try {
			Properties prop = new Properties();
			prop.load(ClassLoader.getSystemResourceAsStream("util/db.properties"));

			driver = prop.getProperty("driver");
			url = prop.getProperty("url");
			username = prop.getProperty("username");
			password = prop.getProperty("password");

			Class.forName(driver);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private Connection getConnection() throws Exception {
		return DriverManager.getConnection(url, username, password);
	}

	// ---------------------------------------------
	// ⭐ 액티비티 생성(Create)
	// ---------------------------------------------
	public int insert(ActivityDTO dto) {
		String sql = "INSERT INTO ACTIVITY "
				+ "(activity_id, title, writer, activity_date, total_people, description, max) "
				+ "VALUES (ACTIVITY_SEQ.NEXTVAL, ?, ?, ?, ?, ?, ?)";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setString(1, dto.getTitle());
			pstmt.setString(2, dto.getWriter());
			pstmt.setString(3, dto.getActivityDate());
			pstmt.setInt(4, dto.getTotalPeople());
			pstmt.setString(5, dto.getDescription());
			pstmt.setInt(6, dto.getMax());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
