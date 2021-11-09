package net.haaim.web.api.user.entity;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;

import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Data
public class IdDuplicationResponse {
	private Boolean duplication;
	private String message; 
	
	@Builder
	public IdDuplicationResponse(Boolean duplication, String message) {
		this.duplication = duplication;
		this.message = message;
	}
}
