package dao;

import java.util.List;

import util.DBUtil;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Properties;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import dto.ActivityDTO;
import oracle.net.aso.c;

public class ActivityDAO {
	private static final String SQL_SELECT_LIST = "SELECT activity_id, title, writer, activity_date, "
			+ "total_people, max FROM ACTIVITY ORDER BY activity_id ASC";
	private static final String SQL_SELECT_BY_ACTIVITY_ID = "SELECT * FROM ACTIVITY WHERE activity_id = ? ORDER BY activity_id ASC";

	// 모든 액티비티 게시글 조회
	public List<ActivityDTO> selectList() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;

		List<ActivityDTO> activityList = new ArrayList<ActivityDTO>();

		try {
			conn = DBUtil.dbConnect();
			st = conn.createStatement();
			rs = st.executeQuery(SQL_SELECT_LIST);
			while (rs.next()) {
				ActivityDTO activityDTO = makeActivity(rs);
				activityList.add(activityDTO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return activityList;

	}

	private ActivityDTO makeActivity(ResultSet rs) throws SQLException {
		ActivityDTO activityDTO = new ActivityDTO();
		activityDTO.setActivityId(rs.getInt("activity_id"));
		activityDTO.setTitle(rs.getString("title"));
		activityDTO.setWriter(rs.getString("writer"));
		activityDTO.setActivityDate(rs.getString("activity_date"));
		activityDTO.setTotalPeople(rs.getInt("total_people"));
		activityDTO.setMax(rs.getInt("max"));
		return activityDTO;
	}

	private ActivityDTO makeActivityID(ResultSet rs) throws SQLException {
		ActivityDTO activityDTO = new ActivityDTO();
		activityDTO.setActivityId(rs.getInt("activity_id"));
		activityDTO.setTitle(rs.getString("title"));
		activityDTO.setWriter(rs.getString("writer"));
		activityDTO.setActivityDate(rs.getString("activity_date"));
		activityDTO.setTotalPeople(rs.getInt("total_people"));
		activityDTO.setMax(rs.getInt("max"));
		activityDTO.setDescription(rs.getString("description"));
		return activityDTO;
	}

	public static ActivityDAO dao = new ActivityDAO();
	private String driver;
	private String url;
	private String username;
	private String password;

	public static ActivityDAO getInstance() {
		return dao;
	}

	public ActivityDAO() {
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

	public ActivityDTO selectByActivityId(int activityId) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ActivityDTO activityDTO = null;

		try {
			conn = DBUtil.dbConnect();
			st = conn.prepareStatement(SQL_SELECT_BY_ACTIVITY_ID);
			st.setInt(1, activityId);
			rs = st.executeQuery();
			while (rs.next()) {
				activityDTO = makeActivityID(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, rs);
		}
		return activityDTO;
	}
}
