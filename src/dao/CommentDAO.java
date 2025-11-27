package dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import dto.CommentDTO;
import util.DBUtil;

public class CommentDAO {

	// ▷ 댓글 Insert
	public int insert(CommentDTO dto) {
		String sql = "INSERT INTO COMMENTS (comment_id, activity_id, nickname, content) "
				+ "VALUES (COMMENTS_SEQ.NEXTVAL, ?, ?, ?)";

		Connection conn = null;
		PreparedStatement pstmt = null;

		try {
			conn = DBUtil.dbConnect();
			if (conn == null) {
				System.out.println("❌ DB 연결 실패 (insert)");
				return 0;
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, dto.getActivityId());
			pstmt.setString(2, dto.getNickname());
			pstmt.setString(3, dto.getContent());

			return pstmt.executeUpdate();

		} catch (SQLIntegrityConstraintViolationException e) {
			System.out.println("무결성 제약 조건 위배 (activity_id 없거나 중복)");
			return -1;

		} catch (SQLException e) {
			System.out.println("댓글 INSERT 중 SQL 오류");
			e.printStackTrace();
			return 0;

		} finally {
			DBUtil.dbDisconnect(conn, pstmt, null);
		}
	}

	// ▷ ActivityID로 댓글 조회
	public List<CommentDTO> selectByActivityId(int activityId) {
		List<CommentDTO> list = new ArrayList<>();

		String sql = "SELECT comment_id, activity_id, nickname, content "
				+ "FROM COMMENTS WHERE activity_id = ? ORDER BY comment_id DESC";

		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {
			conn = DBUtil.dbConnect();
			if (conn == null) {
				System.out.println("DB 연결 실패 (select)");
				return list;
			}

			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, activityId);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				list.add(new CommentDTO(rs.getInt("comment_id"), rs.getInt("activity_id"), rs.getString("nickname"),
						rs.getString("content")));
			}

		} catch (SQLException e) {
			System.out.println("댓글 조회 중 SQL 오류");
			e.printStackTrace();

		} finally {
			DBUtil.dbDisconnect(conn, pstmt, rs);
		}

		return list;
	}
}
