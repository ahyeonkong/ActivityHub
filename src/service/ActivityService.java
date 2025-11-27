package service;

import dao.ActivityDAO;
import dto.ActivityDTO;
import java.util.List;
import dao.ActivityDAO;
import dto.ActivityDTO;

public class ActivityService {
	private ActivityDAO activityDAO = new ActivityDAO();

	public List<ActivityDTO> selectList() {
		return activityDAO.selectList();
	}



	public static String updateService(ActivityDTO act) {
		// TODO Auto-generated method stub
		// return ActivityDAO.update(act);
		return ActivityDAO.update(act);

	}

	public static String insertService(ActivityDTO act) {
		// TODO Auto-generated method stub
		return ActivityDAO.insert(act);
}
}
//import java.util.List;
//
//import dao.ActivityDAO;
//import dto.ActivityDTO;
//
//public class ActivityService {
//	private ActivityDAO activityDAO = new ActivityDAO();
//
//	public List<ActivityDTO> selectList(){
//		return activityDAO.selectList();
//	}>>>>>>>b4b475c3d8a749a539e8d6fadbc50829e0188104
//}
