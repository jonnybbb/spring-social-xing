package org.springframework.social.xing.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class WebProfilesMixin {

    @JsonProperty("qype")
    private List<String> qype;
    @JsonProperty("google_plus")
    private List<String> googlePlus;
    @JsonProperty("blog")
    private List<String> blog;
    @JsonProperty("homepage")
    private List<String> homepage;

}