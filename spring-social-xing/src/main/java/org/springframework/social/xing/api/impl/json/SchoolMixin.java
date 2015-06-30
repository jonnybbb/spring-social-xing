package org.springframework.social.xing.api.impl.json;

import org.springframework.social.xing.api.XingDate;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class SchoolMixin {
	
	@JsonProperty("id")
	private String id;
	@JsonProperty("subject")
	private String subject;
	@JsonProperty("end_date")
	private XingDate endDate;
	@JsonProperty("degree")
	private String degree;
	@JsonProperty("name")
	private String name;
	@JsonProperty("begin_date")
	private XingDate beginDate;
	@JsonProperty("notes")
	private String notes;

}
