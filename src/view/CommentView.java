package view;

import java.util.List;

import dto.CommentDTO;

public class CommentView {

	public static void printComments(List<CommentDTO> list) {

		System.out.println("\n===== 댓글 목록 =====");

		if (list == null || list.isEmpty()) {
			System.out.println("댓글이 없습니다.");
			return;
		}

		for (CommentDTO dto : list) {
			System.out.println("[" + dto.getCommentId() + "] " + dto.getNickname() + " : " + dto.getContent());
		}
		System.out.println("=====================\n");
	}
}
