package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import dto.ActivityDTO;
import util.DBUtil;

public class ActivityDAO {
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
		activityDTO.setActivity_id(rs.getInt("activity_id"));
		activityDTO.setTitle(rs.getString("title"));
		activityDTO.setWriter(rs.getString("writer"));
		activityDTO.setActivity_date(rs.getString("activity_date"));
		activityDTO.setTotal_people(rs.getInt("total_people"));
		activityDTO.setMax(rs.getInt("max"));
		return activityDTO;
	}

}
