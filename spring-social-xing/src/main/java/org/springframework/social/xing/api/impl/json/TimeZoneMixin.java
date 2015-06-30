package org.springframework.social.xing.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class TimeZoneMixin {

    @JsonProperty("name")
    private String name;
    @JsonProperty("utc_offset")
    private Double utcOffset;


}