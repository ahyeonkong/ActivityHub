package controller;

import java.util.Scanner;

import dao.ActivityDAO;
import dto.ActivityDTO;

public class ActivityController implements ControllerInterface {

	@Override
	public void execute(Scanner sc) {

		System.out.println("===== Activity Menu =====");
		System.out.println("1. 액티비티 생성");
		System.out.println("0. 뒤로가기");
		System.out.print("메뉴 선택 >> ");

		int choice = Integer.parseInt(sc.nextLine());

		switch (choice) {
		case 1 -> createActivity(sc);
		case 0 -> System.out.println("이전 메뉴로 돌아갑니다.");
		default -> System.out.println("잘못된 번호입니다.");
		}
	}

	// ⭐ 이 부분이 DAO insert 테스트 부분!!
	private void createActivity(Scanner sc) {
		System.out.println("\n=== 액티비티 생성 ===");

		System.out.print("제목 입력: ");
		String title = sc.nextLine();

		System.out.print("작성자 입력: ");
		String writer = sc.nextLine();

		System.out.print("날짜 입력(예: 25/01/01): ");
		String date = sc.nextLine();

		System.out.print("현재 인원수 입력: ");
		int total = Integer.parseInt(sc.nextLine());

		System.out.print("설명 입력: ");
		String desc = sc.nextLine();

		System.out.print("최대 모집 인원 입력(max): ");
		int max = Integer.parseInt(sc.nextLine());

		ActivityDTO dto = new ActivityDTO(0, title, writer, date, total, desc, max);

		int result = ActivityDAO.getInstance().insert(dto);

		if (result > 0) {
			System.out.println("액티비티 등록 성공!");
		} else {
			System.out.println("액티비티 등록 실패...");
		}
	}
}
