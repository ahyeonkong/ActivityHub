package controller;

import java.util.Scanner;

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
					isStop = true;
				}
				case 1 -> {
					f_select_list();
				}
				case 2 -> {
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

	private void f_select_list() {
		ActivityView.print(activityService.selectList());
	}
}