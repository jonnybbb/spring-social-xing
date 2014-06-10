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
package org.springframework.social.xing.api.impl;

import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.social.xing.api.CareerLevel;
import org.springframework.social.xing.api.EmploymentStatus;
import org.springframework.social.xing.api.FormOfEmployment;
import org.springframework.social.xing.api.XingProfile;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Johannes Buehler
 */
public class ProfileTemplateTest extends AbstractXingApiTest {

	@Test
	public void getUserProfile() {
		mockServer.expect(requestTo(ProfileTemplate.USERS_URL.replaceFirst("\\{id\\}","me"))).andExpect(method(GET))
				.andRespond(withSuccess(new ClassPathResource("testdata/profile.json", getClass()), MediaType.APPLICATION_JSON));
		XingProfile userProfile = xing.profileOperations().getUserProfile();
		assertEquals("6628146_33f97b", userProfile.getId());
		assertEquals("Johannes", userProfile.getFirstName());
		assertEquals("Bühler", userProfile.getLastName());
        assertThat(userProfile.getPermalink(), is(not(nullValue())));
        assertThat(userProfile.getProfessionalExperience(), is(not(nullValue())));
        assertEquals(2, userProfile.getProfessionalExperience().getNonPrimaryCompanies().size());
        assertEquals("CANOOENGINEERINGAG", userProfile.getProfessionalExperience().getPrimaryCompany().getTag());
        assertEquals(Integer.valueOf(1), userProfile.getProfessionalExperience().getPrimaryCompany().getBeginDate().getMonth());
        assertEquals("Senior Software Engineer", userProfile.getProfessionalExperience().getPrimaryCompany().getTitle());
        assertEquals(CareerLevel.PROFESSIONAL_EXPERIENCED, userProfile.getProfessionalExperience().getPrimaryCompany().getCareerLevel());
        assertThat(userProfile.getEducationalBackground(), is(not(nullValue())));
        assertEquals(2, userProfile.getEducationalBackground().getSchools().size());
        assertEquals(3, userProfile.getEducationalBackground().getQualifications().size());
        assertEquals("Java Design Patterns Course Certificate", userProfile.getEducationalBackground().getQualifications().get(2));
        
	}
	
	
	@Test
	public void getFullUserProfile() {
		mockServer.expect(requestTo(ProfileTemplate.USERS_URL.replaceFirst("\\{id\\}","me"))).andExpect(method(GET))
				.andRespond(withSuccess(new ClassPathResource("testdata/full_profile.json", getClass()), MediaType.APPLICATION_JSON));
		XingProfile userProfile = xing.profileOperations().getUserProfile();
		assertEquals("ACM, GI", userProfile.getOrganisationMember());
		assertEquals("m", userProfile.getGender());
		assertEquals("max.mustermann@xing.com", userProfile.getActiveEmail());
        assertThat(userProfile.getEducationalBackground(), is(not(nullValue())));
        assertEquals("1_abcdef", userProfile.getProfessionalExperience().getPrimaryCompany().getId());
        assertEquals(EmploymentStatus.EMPLOYEE, userProfile.getEmploymentStatus());
        assertEquals(FormOfEmployment.FULL_TIME_EMPLOYEE, userProfile.getProfessionalExperience().getPrimaryCompany().getFormOfEmployment());
        assertEquals("42_abcdef", userProfile.getEducationalBackground().getPrimarySchool().getId());
        assertEquals(2, userProfile.getEducationalBackground().getQualifications().size());
        assertEquals("PADI AOWD", userProfile.getEducationalBackground().getQualifications().get(1));
        
	}	
	

	@Test
	public void getProfileId() {
		mockServer.expect(requestTo(ProfileTemplate.USERS_URL.replaceFirst("\\{id\\}","me"))).andExpect(method(GET))
				.andRespond(withSuccess(new ClassPathResource("testdata/profile.json", getClass()), MediaType.APPLICATION_JSON));
		assertEquals("6628146_33f97b", xing.profileOperations().getProfileId());
	}
}
