package net.haaim.web.api.notice.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.haaim.web.api.common.entity.CommonEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class NoticeEntity extends CommonEntity {
	private Integer no;
	
	@NotBlank
	@NotEmpty(message="제목은 필수 값입니다.")
	private String title;
	
	@NotBlank
	@NotEmpty(message="내용은 필수 값입니다.")
	private String contents;
	private Integer state = 1;
}
