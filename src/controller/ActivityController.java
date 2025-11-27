package controller;

import java.util.Scanner;
import dao.ActivityDAO;
import dto.ActivityDTO;
import service.ActivityService;
import view.ActivityView;

import dto.ActivityDTO;
import service.ActivityService;

public class ActivityController implements ControllerInterface {
	static Scanner sc = new Scanner(System.in);
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
					f_insert();
				}
				case 2 -> {
					f_select_list();
				}
<<<<<<< HEAD
				case 3 -> {
					deleteActivity(sc);
=======
				case 4 -> {
					f_update();
>>>>>>> origin/develop
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

<<<<<<< HEAD
	private void deleteActivity(Scanner sc) {
		System.out.println("\n=== 액티비티 삭제 ===");
		System.out.print("삭제할 Activity ID 입력: ");

		try {
			int id = Integer.parseInt(sc.nextLine());
			int result = activityService.delete(id);

			if (result > 0) {
				System.out.println("액티비티 삭제 완료!");
			} else {
				System.out.println("삭제 실패! 존재하지 않는 ID입니다.");
			}

		} catch (NumberFormatException e) {
			System.out.println("숫자를 입력해야 합니다.");
		}
	}

	private void createActivity(Scanner sc) {
		System.out.println("\n=== 액티비티 생성 ===");
=======
//<<<<<<< HEAD
	public static void f_update() {
		ActivityDTO act = new ActivityDTO();
		act = keyboard_insertForUpdate();
		
		ActivityService.updateService(act);
		String message = ActivityService.updateService(act);
		//ActivityView.print(message);
>>>>>>> origin/develop

	}

	public static void f_insert() {
		ActivityDTO act = keyboard_insert();
		String message = ActivityService.insertService(act);
		//ActivityView.print(message);
		
	}

	private static ActivityDTO keyboard_insert() {
		ActivityDTO act = new ActivityDTO();
		System.out.print("제목입력>>");//뷰로 대체 ㄱㄱ
		String title = sc.nextLine();
		
		System.out.print("작성자입력");
		String writer = sc.nextLine();
		
		
		System.out.print("본문");
		String description = sc.nextLine();
		
		System.out.print("최대 인원수 입력>>");
		int max = sc.nextInt();
	    sc.nextLine(); // 버퍼 비우기

		
		act.setTitle(title);
		act.setWriter(writer);
		act.setDescription(description);
		act.setMax(max);
		
		return act;
	}
	
	private static ActivityDTO keyboard_insertForUpdate() {
		ActivityDTO act = new ActivityDTO();
		
		System.out.print("게시물 아이디 입력>> ");
		int activity_id = sc.nextInt();
		sc.nextLine();
		
		System.out.print("제목입력>>");//뷰로 대체 ㄱㄱ
		String title = sc.nextLine();
		
		System.out.print("본문");
		String description = sc.nextLine();
		
		System.out.print("최대 인원수 입력>>");
		int max = sc.nextInt();
		
		act.setActivity_id(activity_id);
		act.setTitle(title);
		act.setDescription(description);
		act.setMax(max);
		
		return act;
	}

//=======


	private void f_select_list() {
		ActivityView.print(activityService.selectList());
	}
//>>>>>>> b4b475c3d8a749a539e8d6fadbc50829e0188104
}
