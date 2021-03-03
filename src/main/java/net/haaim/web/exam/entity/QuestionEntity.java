package net.haaim.web.exam.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@Entity 
@Table(name = "exam_list")
@Getter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class QuestionEntity extends CommonEntity{
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "exam_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer examNo;
	
	@Column(name = "user_id")
	@JsonProperty(value = "user_id", access = JsonProperty.Access.AUTO)
	private String userId;
	
	@Column(name = "date")
	@JsonProperty(value = "usdateer_id", access = JsonProperty.Access.AUTO)
	private String date;
	
	@Column(name = "class_no")
	@JsonProperty(value = "class_no", access = JsonProperty.Access.AUTO)
	private Integer classNo;
	
	@Column(name = "grade")
	@JsonProperty(value = "grade", access = JsonProperty.Access.AUTO)
	private Integer grade;
	
	@Column(name = "course")
	@JsonProperty(value = "course", access = JsonProperty.Access.AUTO)
	private String course;
	
	@Column(name = "large_category")
	@JsonProperty(value = "large_category", access = JsonProperty.Access.AUTO)
	private String largeCategory;
	
	@Column(name = "medium_category")
	@JsonProperty(value = "medium_category", access = JsonProperty.Access.AUTO)
	private String mediumCategory;
	
	@Column(name = "type_group")
	@JsonProperty(value = "type_group", access = JsonProperty.Access.AUTO)
	private String typeGroup;
	
	@Column(name = "count")
	@JsonProperty(value = "count", access = JsonProperty.Access.AUTO)
	private Integer count;
	
	@Column(name = "level_difficulty")
	@JsonProperty(value = "level_difficulty", access = JsonProperty.Access.AUTO)
	private Integer levelDifficulty;
	
	@Column(name = "target")
	@JsonProperty(value = "target", access = JsonProperty.Access.AUTO)
	private String target;
	
	@Column(name = "goal_score")
	@JsonProperty(value = "goal_score", access = JsonProperty.Access.AUTO)
	private Integer goalScore;
	
	@Column(name = "state")
	@JsonProperty(value = "state", access = JsonProperty.Access.AUTO)
	private Integer state;
	
	@Column(name = "stare")
	@JsonProperty(value = "stare", access = JsonProperty.Access.AUTO)
	private Integer stare;
	
	@Column(name = "stare_date", nullable = true, unique = false)
	@JsonProperty(value = "stare_date", access = JsonProperty.Access.AUTO)
	private Date stareDate;
	
	@Column(name = "stare_score")
	@JsonProperty(value = "stare_score", access = JsonProperty.Access.AUTO)
	private Integer stareScore;
	
	@Builder
	public QuestionEntity(String inputId, Date inputDate, String updateId, Date updateDate, Integer examNo,
			String userId, String date, Integer classNo, Integer grade, String course, String largeCategory,
			String mediumCategory, String typeGroup, Integer count, Integer levelDifficulty, String target,
			Integer goalScore, Integer state, Integer stare, Date stareDate, Integer stareScore) {
		super(inputId, inputDate, updateId, updateDate);
		this.examNo = examNo;
		this.userId = userId;
		this.date = date;
		this.classNo = classNo;
		this.grade = grade;
		this.course = course;
		this.largeCategory = largeCategory;
		this.mediumCategory = mediumCategory;
		this.typeGroup = typeGroup;
		this.count = count;
		this.levelDifficulty = levelDifficulty;
		this.target = target;
		this.goalScore = goalScore;
		this.state = state;
		this.stare = stare;
		this.stareDate = stareDate;
		this.stareScore = stareScore;
	}
}

