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
package org.springframework.social.xing.api;

import java.io.Serializable;

/**
 * Model class containing a user's Xing profile information.
 *
 * @author Johannes Buehler
 * @author Dominik Bartholdi <domi@fortysix.ch>
 */
public class XingProfile implements Serializable {


    private static final long serialVersionUID = -6567173579938863785L;
    private BirthDate birthDate;
    private PhotoUrls photoUrls;
    private String interests;
    private String wants;
    private String organisationMember;
    private String gender;
    private String pageName;
    private BusinessAddress businessAddress;
    private String haves;
    private String id;
    private String firstName;
    private String lastName;
    private String permalink;
    private String activeEmail;
    private String displayName;
    private EmploymentStatus employmentStatus;
    private ProfessionalExperience professionalExperience;
    private EducationalBackground educationalBackground;


    public XingProfile() {
    }

    public XingProfile(
            String id,
            String firstName,
            String lastName,
            String permalink,
            String activeEmail,
            String displayName
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.permalink = permalink;
        this.activeEmail = activeEmail;
        this.displayName = displayName;
    }


    public void setBirthDate(BirthDate birthDate) {
        this.birthDate = birthDate;
    }

    public void setPhotoUrls(PhotoUrls photoUrls) {
        this.photoUrls = photoUrls;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }

    public void setWants(String wants) {
        this.wants = wants;
    }

    public void setOrganisationMember(String organisationMember) {
        this.organisationMember = organisationMember;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    public void setBusinessAddress(BusinessAddress businessAddress) {
        this.businessAddress = businessAddress;
    }

    public void setHaves(String haves) {
        this.haves = haves;
    }

    public BirthDate getBirthDate() {
        return birthDate;
    }

    public PhotoUrls getPhotoUrls() {
        return photoUrls;
    }

    public String getInterests() {
        return interests;
    }

    public String getWants() {
        return wants;
    }

    public String getOrganisationMember() {
        return organisationMember;
    }

    public String getGender() {
        return gender;
    }

    public String getPageName() {
        return pageName;
    }

    public BusinessAddress getBusinessAddress() {
        return businessAddress;
    }

    public String getHaves() {
        return haves;
    }

    public String getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPermalink() {
        return permalink;
    }

    public String getActiveEmail() {
        return activeEmail;
    }

    public String getDisplayName() {
        return displayName;
    }

    public ProfessionalExperience getProfessionalExperience() {
        return professionalExperience;
    }

    public EducationalBackground getEducationalBackground() {
        return educationalBackground;
    }

    public EmploymentStatus getEmploymentStatus() {
        return employmentStatus;
    }
}
