package controller;

import java.util.Scanner;

import dto.CommentDTO;
import service.CommentService;
import view.CommentView;

public class CommentController implements ControllerInterface {

	@Override
	public void execute(Scanner sc) {

		System.out.println("===== 댓글 메뉴 =====");
		System.out.println("1. 댓글 작성");
		System.out.println("0. 뒤로가기");
		System.out.print("메뉴 선택 >> ");

		int choice = Integer.parseInt(sc.nextLine());

		switch (choice) {
		case 1 -> insertComment(sc);
		case 0 -> System.out.println("이전 메뉴로 돌아갑니다.");
		default -> System.out.println("잘못된 입력입니다.");
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

		CommentService service = new CommentService();
		CommentView view = new CommentView();

		int result = service.createComment(dto);
		view.printCreateResult(result);
	}
}
