package view;

import dto.CommentDTO;

public class CommentView {

	public void printCreateResult(int result) {
		if (result > 0) {
			System.out.println(" 댓글이 성공적으로 등록되었습니다!");
		} else {
			System.out.println(" 댓글 등록에 실패했습니다.");
		}
	}

	public void printComment(CommentDTO dto) {
		System.out.println("----------------------");
		System.out.println("닉네임: " + dto.getNickname());
		System.out.println("내용: " + dto.getContent());
		System.out.println("----------------------");
	}
}
