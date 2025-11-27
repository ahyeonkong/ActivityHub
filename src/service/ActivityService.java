package service;

import dao.ActivityDAO;
import dto.ActivityDTO;

public class ActivityService {

//	public static void updateService(ActivityDTO act) {
	public static String updateService(ActivityDTO act) {
		// TODO Auto-generated method stub
		//return ActivityDAO.update(act);
		return ActivityDAO.update(act);
		
	}

	public static String insertService(ActivityDTO act) {
		// TODO Auto-generated method stub
		return ActivityDAO.insert(act);
	}

}
