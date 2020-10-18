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
import net.haaim.web.common.entity.CommonEntity;

@Entity
@Table(name = "notice")
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class NoticeEntity extends CommonEntity {
	public static final int VIEW = 1;
	
	@Id // pk
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "no")
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer no;

	@Column(name = "title", nullable = true, unique = false, length = 100)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String title;

	@Column(name = "contents", nullable = true, unique = false, length = 1024)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private String contents;

	/** 상태(0:HIDDEN/1:VIEW) */
	@Column(name = "state", nullable = true, unique = false)
	@JsonProperty(access = JsonProperty.Access.AUTO)
	private Integer state;

	

	@Builder
	public NoticeEntity(String title, String contents, int state) {
		
		super();
		
		this.title = title;
		this.contents = contents;
		this.state = state;

		validate(title, contents);
	}

	@Builder
	public NoticeEntity(String title, String contents, int state, String inputId, Date inputDate, String updateId,
			Date updateDate) {
		
		super(inputId, inputDate, updateId, updateDate);
		
		this.title = title;
		this.contents = contents;
		this.state = state;
		
		validate(title, contents);
		
		
	}
	
	private void validate(String title, String contents) {
		Assert.hasText(title, "title must not be empty");
		Assert.hasText(contents, "contents must not be empty");
	}
}
