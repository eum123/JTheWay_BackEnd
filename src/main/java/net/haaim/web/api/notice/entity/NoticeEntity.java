package net.haaim.web.api.notice.entity;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import net.haaim.web.api.common.entity.CommonEntity;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class NoticeEntity extends CommonEntity {
	private Integer no;
	
	@Schema(description="제목.", nullable = false)
	@NotBlank
	@NotEmpty(message="제목은 필수 값입니다.")
	private String title;
	
	@Schema(description="내용.", nullable = false)
	@NotBlank
	@NotEmpty(message="내용은 필수 값입니다.")
	private String contents;
	
	@Schema(description="표시 여부.", allowableValues = {"0", "1"})
	private Integer state = 1;
}
