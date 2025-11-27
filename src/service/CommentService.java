package service;

import dao.CommentDAO;
import dto.CommentDTO;

public class CommentService {

	public int createComment(CommentDTO dto) {

		if (dto.getNickname() == null || dto.getNickname().isBlank()) {
			System.out.println("닉네임은 필수입니다.");
			return 0;
		}

		if (dto.getContent() == null || dto.getContent().isBlank()) {
			System.out.println("내용을 입력해주세요.");
			return 0;
		}

		return CommentDAO.getInstance().insert(dto);
	}
}
