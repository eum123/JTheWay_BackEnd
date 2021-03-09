package net.haaim.web.student.entity;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class ExamNowCountDTO {
	
	@Column(name = "count")
	@JsonProperty(access = JsonProperty.Access.AUTO)	
	private Integer count;
	
	@Builder
	public ExamNowCountDTO(Integer count) {
		super();
		this.count = count;
	}

}
