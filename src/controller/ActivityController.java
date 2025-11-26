package controller;

import java.util.Scanner;

import dto.ActivityDTO;
import service.ActivityService;

public class ActivityController implements ControllerInterface {
	static Scanner sc = new Scanner(System.in);


	@Override
	public void execute(Scanner sc) {
		// TODO Auto-generated method stub
		
	}

	public static void f_update() {
		//ActivityDTO act = new ActivityDTO();
		//test
		int act = 1;
		ActivityService.updateService(act);
		
	}

	public static void f_insert() {
		ActivityDTO act = keyboard_insert();
		String message = ActivityService.insertService(act);
		//ActivityView.print(message);
		
	}

	private static ActivityDTO keyboard_insert() {
		ActivityDTO act = new ActivityDTO();
		System.out.print("제목입력>>");//뷰로 대체 ㄱㄱ
		String title = sc.next();
		
		System.out.print("작성자입력");
		String writer = sc.next();
		
		
		System.out.print("본문");
		String description = sc.next();
		
		System.out.print("최대 인원수 입력>>");
		int max = sc.nextInt();
		
		act.setTitle(title);
		act.setWriter(writer);
		act.setDescription(description);
		act.setMax(max);
		
		return act;
	}

}
