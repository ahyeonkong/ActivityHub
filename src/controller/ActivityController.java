package controller;

import java.util.Scanner;
import dao.ActivityDAO;
import dto.ActivityDTO;
import service.ActivityService;
import view.ActivityView;

public class ActivityController implements ControllerInterface {

	Scanner sc = new Scanner(System.in);
	ActivityService activityService = new ActivityService();

	@Override
	public void execute(Scanner sc) {
		this.sc = sc;
		boolean isStop = false;
		while (!isStop) {
			ActivityView.menu();
			System.out.print("메뉴를 선택하세요. >> ");
			try {
				int job = Integer.parseInt(sc.nextLine());
				switch (job) {
				case 0 -> {
					System.out.println("이전 메뉴로 돌아갑니다.");
					isStop = true;
				}
				case 1 -> {
					createActivity(sc);
				}
				case 2 -> {
					f_select_list();
				}
				default -> {
					ActivityView.print("잘못 선택했습니다.");
				}
				}
			} catch (NumberFormatException e) {
				ActivityView.print("숫자를 입력하세요.");
			}
		}
	}

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

	private void f_select_list() {
		ActivityView.print(activityService.selectList());
	}
}
