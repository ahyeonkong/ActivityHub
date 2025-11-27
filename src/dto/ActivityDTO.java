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
	//private String title;
	//private String writer;
	private String activityDate;
	private int totalPeople;
	//private String description;
	//private int max;
}


//CREATE TABLE ACTIVITY (
//	    activity_id     NUMBER(10)       PRIMARY KEY,
//	    title           VARCHAR2(200)    NOT NULL,
//	    writer          VARCHAR2(100)    NOT NULL,
//	    activity_date   VARCHAR2(20)     NOT NULL,
//	    total_people    NUMBER(5)        NOT NULL,
//	    description     VARCHAR2(1000),
//	    max             NUMBER(5)        NOT NULL
//	)TABLESPACE users;

//CREATE TABLE COMMENTS (
//    comment_id     NUMBER(10)       PRIMARY KEY,
//    activity_id    NUMBER(10)       NOT NULL,
//    nickname       VARCHAR2(100)    NOT NULL,
//    content        VARCHAR2(1000)   NOT NULL,
//    
//    CONSTRAINT fk_activity
//        FOREIGN KEY (activity_id)
//        REFERENCES ACTIVITY(activity_id)
//        ON DELETE CASCADE
//)TABLESPACE users;