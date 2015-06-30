package org.springframework.social.xing.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)

abstract class InstantMessagingAccountsMixin {

    @JsonProperty("skype")
    private String skype;
    @JsonProperty("googletalk")
    private String googletalk;


}
