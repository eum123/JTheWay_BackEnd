package net.haaim.web.notice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name="notice")
@NoArgsConstructor()
@Data 
public class NoticeEntity {
	@Id // pk
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="no")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private int no;
	
	@Column(name="title", nullable = true, unique = false, length = 100)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String title;
	
	@Column(name="contents", nullable = true, unique = false, length = 1024)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String contents;
	
	/** 상태(0:HIDDEN/1:VIEW) */
	@Column(name="state", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int state;
	
	@Column(name="input_id", nullable = true, unique = false, length = 45)
	@JsonProperty(value="input_id", access = JsonProperty.Access.WRITE_ONLY)
	private String InputId;
	
	@Column(name="input_date", nullable = true, unique = false)
	@JsonProperty(value="input_date", access = JsonProperty.Access.WRITE_ONLY)
	private Date inputDate;
	
	@Column(name="update_id", nullable = true, unique = false, length = 45)
	@JsonProperty(value="update_id", access = JsonProperty.Access.WRITE_ONLY)
	private String updateId;
	
	@Column(name="update_date", nullable = true, unique = false)
	@JsonProperty(value="update_date", access = JsonProperty.Access.WRITE_ONLY)
	private Date updateDate;
	
	
	public NoticeEntity(String title, String contents, int state) {
		
	}
}
