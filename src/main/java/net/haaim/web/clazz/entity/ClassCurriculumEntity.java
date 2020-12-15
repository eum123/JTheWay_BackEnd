package net.haaim.web.clazz.entity;

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
@Table(name = "class_curriculum")
@Getter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class ClassCurriculumEntity extends CommonEntity {
	

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer no;
	
	@Column(name = "class_no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer classNo;
	
	@Column(name = "cur_id")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer curriculumNo;
	
	@Builder
	public ClassCurriculumEntity(String inputId, Date inputDate, String updateId, Date updateDate, Integer classNo,
			Integer curriculumNo) {
		super(inputId, inputDate, updateId, updateDate);
		this.classNo = classNo;
		this.curriculumNo = curriculumNo;
	}
}
