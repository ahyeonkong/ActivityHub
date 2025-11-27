package controller;

import java.util.Scanner;
import dto.CommentDTO;
import service.CommentService;

public class CommentController implements ControllerInterface {

	private CommentService service = new CommentService();

	@Override
	public void execute(Scanner sc) {
		while (true) {
			System.out.println("\n===== 댓글 메뉴 =====");
			System.out.println("1. 댓글 작성");
			System.out.println("0. 뒤로가기");
			System.out.print("메뉴 선택 >> ");

			int menu = Integer.parseInt(sc.nextLine());

			switch (menu) {
			case 1 -> insertComment(sc);
			case 0 -> {
				return;
			}
			default -> System.out.println("잘못된 번호");
			}
		}
	}

	private void insertComment(Scanner sc) {
		System.out.print("Activity ID 입력: ");
		int activityId = Integer.parseInt(sc.nextLine());

		System.out.print("닉네임 입력: ");
		String nickname = sc.nextLine();

		System.out.print("댓글 내용 입력: ");
		String content = sc.nextLine();

		CommentDTO dto = new CommentDTO(0, activityId, nickname, content);

		boolean success = service.addComment(dto);

		if (success)
			System.out.println("댓글 등록 성공!");
		else
			System.out.println("댓글 등록 실패!");
	}
}
