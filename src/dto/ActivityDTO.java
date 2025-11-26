package dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ActivityDTO {
	private int activityId;
	private String title;
	private String writer;
	private String activityDate;
	private int totalPeople;
	private String description;
	private int max;
}
