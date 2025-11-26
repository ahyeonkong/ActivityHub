package dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ActivityDTO {
	private Integer activity_id;
	private String title;
	private String writer;
	private String activity_date;
	private Integer total_people;
	private String description;
	private Integer max;
}
