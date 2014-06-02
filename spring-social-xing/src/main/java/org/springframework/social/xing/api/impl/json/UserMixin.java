package org.springframework.social.xing.api.impl.json;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
*
*/
abstract class UserMixin {
    @JsonProperty("id")
    private String id;
}
