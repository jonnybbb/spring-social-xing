
package org.springframework.social.xing.api.impl.json;


import org.codehaus.jackson.annotate.JsonCreator;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.codehaus.jackson.annotate.JsonProperty;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class BirthDateMixin {

    @JsonCreator
     BirthDateMixin(@JsonProperty("day") Long day,
                    @JsonProperty("year") Long year,
                    @JsonProperty("month") Long month) {

    }

}
