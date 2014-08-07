package org.springframework.social.xing.api.impl.json;

import org.springframework.social.xing.api.CareerLevel;
import org.springframework.social.xing.api.XingDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class CompanyMixin {
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("industry")
	private String industry;
	@JsonProperty("company_size")
	private String companySize;
	@JsonProperty("end_date")
	private XingDate endDate;
	@JsonProperty("tag")
	private String tag;
	@JsonProperty("name")
	private String name;
	@JsonProperty("url")
	private String url;
	@JsonProperty("career_level")
	private CareerLevel careerLevel;
	@JsonProperty("title")
	private String title;
	@JsonProperty("begin_date")
	private XingDate beginDate;
	@JsonProperty("description")
	private String description;
	@JsonProperty("until_now")
	private Boolean untilNow;

}
