package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import dto.ActivityDTO;
import util.DBUtil;

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

}
