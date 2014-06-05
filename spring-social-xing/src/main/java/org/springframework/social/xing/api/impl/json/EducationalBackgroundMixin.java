package org.springframework.social.xing.api.impl.json;

import java.util.List;

import org.springframework.social.xing.api.School;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
public class EducationalBackgroundMixin {

	@JsonProperty("primary_school")
	private School primarySchool;
	@JsonProperty("qualifications")
	private List<String> qualifications;
	@JsonProperty("schools")
	private List<School> schools;

}
