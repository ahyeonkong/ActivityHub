package controller;

import java.util.Scanner;

public class FrontController {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ControllerInterface controllerInterface = null;

		boolean isStop = false;
		while (!isStop) {
			System.out.println("========================================MENU========================================");
			System.out.println();
			System.out.println("0.종료 | 1.Activity | 2.Comments");
			System.out.println();
			System.out.println("====================================================================================");
			System.out.print("메뉴를 선택하세요. >> ");
			try {
				int job = Integer.parseInt(sc.nextLine());

				switch (job) {
				case 0 -> {
					isStop = true;
					controllerInterface = null;
				}
				case 1 -> {
					controllerInterface = new ActivityController();
				}
				case 2 -> {
					controllerInterface = new CommentController();
				}
				default -> {
					controllerInterface = null;
				}
				}
				if (controllerInterface != null)
					controllerInterface.execute(sc);
			} catch (NumberFormatException e) {
				System.out.println("숫자만 입력해주세요.");
			}
		}
		sc.close();

	}
}