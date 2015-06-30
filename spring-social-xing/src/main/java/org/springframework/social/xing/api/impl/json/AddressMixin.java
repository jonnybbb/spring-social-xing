package org.springframework.social.xing.api.impl.json;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by json2pojo
 */
@JsonIgnoreProperties(ignoreUnknown = true)
abstract class AddressMixin {

    @JsonProperty("fax")
    String fax;
    @JsonProperty("mobile_phone")
    String mobilePhone;
    @JsonProperty("phone")
    String phone;
    @JsonProperty("zip_code")
    String zipCode;
    @JsonProperty("country")
    String country;
    @JsonProperty("province")
    String province;
    @JsonProperty("city")
    String city;
    @JsonProperty("street")
    String street;
    @JsonProperty("email")
    String email;

}
