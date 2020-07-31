package net.haaim.web.notice.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.util.Assert;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "notice")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NoticeEntity {
	public static final int VIEW = 1;
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int no;

	@Column(name = "title", nullable = true, unique = false, length = 100)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String title;

	@Column(name = "contents", nullable = true, unique = false, length = 1024)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private String contents;

	/** 상태(0:HIDDEN/1:VIEW) */
	@Column(name = "state", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private int state;

	@Column(name = "input_id", nullable = true, unique = false, length = 45)
	@JsonProperty(value = "input_id", access = JsonProperty.Access.WRITE_ONLY)
	private String inputId;

	@Column(name = "input_date", nullable = true, unique = false)
	@JsonProperty(value = "input_date", access = JsonProperty.Access.WRITE_ONLY)
	private Date inputDate;

	@Column(name = "update_id", nullable = true, unique = false, length = 45)
	@JsonProperty(value = "update_id", access = JsonProperty.Access.WRITE_ONLY)
	private String updateId;

	@Column(name = "update_date", nullable = true, unique = false)
	@JsonProperty(value = "update_date", access = JsonProperty.Access.WRITE_ONLY)
	private Date updateDate;

	@Builder
	public NoticeEntity(String title, String contents, int state) {
		validate(title, contents);

		this.title = title;
		this.contents = contents;
		this.state = state;

	}

	@Builder
	public NoticeEntity(String title, String contents, int state, String intputId, Date inputDate, String updateId,
			Date updateDate) {
		validate(title, contents);
		
		this.title = title;
		this.contents = contents;
		this.state = state;
		this.inputId = intputId;
		this.inputDate = inputDate;
		this.updateId = updateId;
		this.updateDate = updateDate;
	}
	
	private void validate(String title, String contents) {
		Assert.hasText(title, "title must not be empty");
		Assert.hasText(contents, "contents must not be empty");
	}
}
