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


	public int delete(int id) {
		return activityDAO.delete(id);
	}


	public ActivityDTO selectByActivityId(int activityId) {
		return activityDAO.selectByActivityId(activityId);
	}

	public static String updateService(ActivityDTO act) {
		return ActivityDAO.update(act);

	}

	public static String insertService(ActivityDTO act) {
		return ActivityDAO.insert(act);

}
}

