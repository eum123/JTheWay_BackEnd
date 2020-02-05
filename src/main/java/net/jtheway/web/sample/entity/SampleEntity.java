package net.jtheway.web.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Data;

@Entity
@Data
@Table(name="SAMPLE")
public class SampleEntity {
	@Id
	@Column(name="name", nullable=false)
	@JsonProperty
	private String name;
	
	@Column(name="age", nullable=false)
	@JsonProperty
	private int age;
	
}
