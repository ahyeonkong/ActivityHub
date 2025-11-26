package view;

import java.util.List;

import dto.ActivityDTO;

public class ActivityView {
	public static void menu() {
		System.out.println("====================================================================================");
		System.out.println();
		System.out.println("0.이전");
		System.out.println("1.액티비티 모집글 목록 조회");
		System.out.println();
		System.out.println("====================================================================================");
	}
	
	public static void print(String message) {
		System.out.println("[알림] " + message);
	}
	
	public static void print(ActivityDTO activityDTO) {
		print("게시글 1건에 대한 정보입니다.");
		display(activityDTO);
	}
	
	public static void print(List<ActivityDTO> activityList) {
		print("게시글 목록입니다.");
		for(ActivityDTO activityDTO: activityList) {
			display(activityDTO);
		}
	}

	public static void display(ActivityDTO activityDTO) {
	    if (activityDTO == null) {
	        ActivityView.print("게시글이 존재하지 않습니다.");
	        return;
	    }

	    // 컬럼 헤더
	    System.out.printf("│ %-3s │ %-20s │ %-7s │ %-10s │ %-6s │ %-6s │%n",
	            "ID", "제목", "작성자", "작성일", "참여인원", "최대인원");

	    System.out.println("------------------------------------------------------------------------------------");

	    // 데이터 출력
	    System.out.printf("│ %-3s │ %-20s │ %-7s │ %-10s │ %-6s │ %-6s │%n",
	            activityDTO.getActivity_id(),
	            truncate(activityDTO.getTitle(), 20),
	            activityDTO.getWriter(),
	            activityDTO.getActivity_date(),
	            activityDTO.getTotal_people(),
	            activityDTO.getMax());
	    
	    System.out.println("------------------------------------------------------------------------------------");
	    System.out.println("------------------------------------------------------------------------------------");
	}

	// 제목이 길 경우 잘라주는 함수
	private static String truncate(String str, int maxLength) {
	    if (str.length() <= maxLength) return str;
	    return str.substring(0, maxLength - 3) + "...";
	}
}
