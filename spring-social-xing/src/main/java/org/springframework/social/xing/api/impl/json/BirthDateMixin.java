
package org.springframework.social.xing.api.impl.json;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class BirthDateMixin {

    @JsonCreator
     BirthDateMixin(@JsonProperty("day") Long day,
                    @JsonProperty("year") Long year,
                    @JsonProperty("month") Long month) {

    }

}
