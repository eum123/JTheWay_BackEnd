package net.haaim.web.user.entity;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Builder;

public class DuplicateEntity {
	@JsonProperty(value = "duplicate", access = JsonProperty.Access.AUTO)
	private boolean isDuplidate = false;
	
	@Builder
	public DuplicateEntity(boolean isDuplicate) {
		this.isDuplidate = isDuplicate;
	}
}
