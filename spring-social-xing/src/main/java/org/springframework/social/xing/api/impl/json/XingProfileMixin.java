/*
 * Copyright 2012 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.xing.api.impl.json;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.social.xing.api.*;

import java.util.List;
import java.util.Map;

@JsonIgnoreProperties(ignoreUnknown = true)
abstract class XingProfileMixin {

    @JsonCreator
    XingProfileMixin(@JsonProperty("id") String id,
                     @JsonProperty("first_name") String firstName,
                     @JsonProperty("last_name") String lastName,
                     @JsonProperty("permalink") String permalink,
                     @JsonProperty("active_email") String activeEmail,
                     @JsonProperty("display_name") String displayName) {
    }

    @JsonProperty("birth_date")
    private BirthDate birthDate;
    @JsonProperty("photo_urls")
    private PhotoUrls photoUrls;
    @JsonProperty("interests")
    private String interests;
    @JsonProperty("badges")
    private List<String> badges;
    @JsonProperty("wants")
    private String wants;
    @JsonProperty("organisation_member")
    private String organisationMember;
    @JsonProperty("gender")
    private String gender;
    @JsonProperty("page_name")
    private String pageName;
    @JsonProperty("business_address")
    private BusinessAddress businessAddress;
    @JsonProperty("haves")
    private String haves;
    @JsonProperty("professional_experience")
    private ProfessionalExperience professionalExperience;
    @JsonProperty("employment_status")
    private EmploymentStatus employmentStatus;
    @JsonProperty("form_of_employment")
    private FormOfEmployment formOfEmployment;
    @JsonProperty("languages")
    private Map<Language, LanguageSkill> languages;
}

