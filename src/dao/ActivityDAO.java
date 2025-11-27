package dao;

//<<<<<<< HEAD
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ActivityDTO;
import util.DBUtil;

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

public class ActivityDAO {
	
	//액티비티 모집글 작성
	public static String insert(ActivityDTO act) {
		String message = null;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = """
				INSERT INTO ACTIVITY
				(activity_id, title, writer, activity_date, total_people, description, max)
				VALUES (ACTIVITY_SEQ.NEXTVAL, ?, ?, sysdate, ?, ?, ?)
				""";
		
		conn = DBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, act.getTitle());
			st.setString(2, act.getWriter());
			st.setInt(3, 1);
			st.setString(4, act.getDescription());
			st.setInt(5, act.getMax());
			
			
			int result = st.executeUpdate();
			message = result + "건 입력";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		
		return message;
	}
	

	public static String update(ActivityDTO act) {
		String message = null;
		Connection conn = null;
		PreparedStatement st = null;
		String sql = null;
		
		sql = """
				UPDATE activity
				SET
					title = ?||'  ('||sysdate||'에 수정됨)',
					activity_date= trunc(sysdate),
					description = ?,
					max = ?
				WHERE activity_id = ?
				""";

		conn = DBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);

			st.setString(1, act.getTitle());
			st.setString(2, act.getDescription());
			st.setInt(3,act.getMax());
			st.setInt(4,act.getActivity_id());

			st.executeUpdate();
			message = "메세지~~~";
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBUtil.dbDisconnect(conn, st, null);
		}
		return message;
	}
//=======




	private static final String SQL_SELECT_LIST = "SELECT activity_id, title, writer, activity_date, total_people, max FROM ACTIVITY";

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

	public int delete(int activityId) {
		String sql = "DELETE FROM ACTIVITY WHERE activity_id = ?";

		try (Connection conn = DBUtil.dbConnect(); PreparedStatement pstmt = conn.prepareStatement(sql)) {

			pstmt.setInt(1, activityId);
			return pstmt.executeUpdate(); 

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
	}



}
