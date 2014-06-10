package org.springframework.social.xing.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
public class AwardMixin {
	@JsonProperty("name")
	private String name;
	@JsonProperty("date_awarded")
	private Long dateAwarded;
	@JsonProperty("url")
	private Object url;

}
