package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@Data
@NoArgsConstructor
public class ActivityDTO {
	private Integer activity_id;  
	private String title;
	private String writer;
	private String activity_date;
	private Integer total_people;
	private String description;
	private Integer max;
	private int activityId;
	private String activityDate;
	private int totalPeople;

}


