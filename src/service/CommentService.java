package service;

import java.util.List;

import dao.CommentDAO;
import dto.CommentDTO;

public class CommentService {

	private CommentDAO dao = new CommentDAO();

	public boolean addComment(CommentDTO dto) {
		int result = dao.insert(dto);
		return result > 0;
	}

	public List<CommentDTO> getComments(int activityId) {
		return dao.selectByActivityId(activityId);
	}
}
