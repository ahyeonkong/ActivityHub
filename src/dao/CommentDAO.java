package dao;

import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;

import dto.CommentDTO;

public class CommentDAO {

	private static CommentDAO dao = new CommentDAO();
	private String driver;
	private String url;
	private String username;
	private String password;

	public static CommentDAO getInstance() {
		return dao;
	}

	private CommentDAO() {
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

	// 댓글 INSERT
	public int insert(CommentDTO dto) {

		String sql = "INSERT INTO COMMENTS " + "(comment_id, activity_id, nickname, content) "
				+ "VALUES (COMMENT_SEQ.NEXTVAL, ?, ?, ?)";

		try (Connection conn = getConnection(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, dto.getActivityId());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getContent());

			return pstmt.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}
}
