package org.springframework.social.xing.api.impl.json;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.xing.api.User;

import java.util.List;

/**
*
*/
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class ContactsMixin {
    @JsonProperty("total")
    private Integer total;
    @JsonProperty("users")
    private List<User> users;
}
