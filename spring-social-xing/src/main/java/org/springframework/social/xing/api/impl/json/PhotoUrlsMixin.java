package org.springframework.social.xing.api.impl.json;


import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class PhotoUrlsMixin {

    @JsonProperty("medium_thumb")
    String mediumThumb;
    @JsonProperty("thumb")
    String thumb;
    @JsonProperty("mini_thumb")
    String miniThumb;
    @JsonProperty("maxi_thumb")
    String maxiThumb;
    @JsonProperty("large")
    String large;

}
