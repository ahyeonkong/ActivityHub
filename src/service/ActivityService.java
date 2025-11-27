package service;

import java.util.List;

import dao.ActivityDAO;
import dto.ActivityDTO;

public class ActivityService {
	private ActivityDAO activityDAO = new ActivityDAO();

	public List<ActivityDTO> selectList() {
		return activityDAO.selectList();
	}

	public ActivityDTO selectByActivityId(int activityId) {
		return activityDAO.selectByActivityId(activityId);
	}
}
