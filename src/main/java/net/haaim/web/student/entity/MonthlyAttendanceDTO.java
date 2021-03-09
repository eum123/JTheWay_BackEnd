package net.haaim.web.student.entity;

import java.util.Date;

import javax.persistence.Column;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.haaim.web.common.entity.CommonEntity;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class MonthlyAttendanceDTO extends CommonEntity {
	
	@Column(name = "attendance")
	@JsonProperty(access = JsonProperty.Access.AUTO)	
	private Integer attendance;
	
	@Column(name = "miss")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer miss;
	
	@Column(name = "remain")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer remain;
	
	@Builder
	public MonthlyAttendanceDTO(String inputId, Date inputDate, String updateId, Date updateDate, Integer attendance,
			Integer miss, Integer remain) {
		super(inputId, inputDate, updateId, updateDate);
		this.attendance = attendance;
		this.miss = miss;
		this.remain = remain;
	}
}
