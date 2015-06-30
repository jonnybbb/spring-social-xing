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

import org.hamcrest.CoreMatchers;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;
import org.springframework.http.MediaType;
import org.springframework.social.xing.api.CareerLevel;
import org.springframework.social.xing.api.EmploymentStatus;
import org.springframework.social.xing.api.FormOfEmployment;
import org.springframework.social.xing.api.XingProfile;

import java.util.List;

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
		mockServer.expect(requestTo(XingTemplate.DEFAULT_BASE_URL + ProfileTemplate.USERS_URL.replaceFirst("\\{id\\}", "me"))).andExpect(method(GET))
				.andRespond(withSuccess(new ClassPathResource("testdata/profile.json", getClass()), MediaType.APPLICATION_JSON));
		XingProfile userProfile = xing.profileOperations().getUserProfile();
		assertEquals("6628146_33f97b", userProfile.getId());
		assertEquals("Johannes", userProfile.getFirstName());
		assertEquals("Bühler", userProfile.getLastName());

		List<String> badges = userProfile.getBadges();
		assertEquals(1, badges.size());
		assertEquals("PREMIUM", badges.get(0));

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
		assertEquals("http://www.xing.com/assets/frontend_minified/img/users/nobody_m.32x32.jpg", userProfile.getPhotoUrls().getSize_32x32());
		assertEquals("http://www.xing.com/assets/frontend_minified/img/users/nobody_m.48x48.jpg", userProfile.getPhotoUrls().getSize_48x48());
		assertEquals("http://www.xing.com/assets/frontend_minified/img/users/nobody_m.64x64.jpg", userProfile.getPhotoUrls().getSize_64x64());
		assertEquals("http://www.xing.com/assets/frontend_minified/img/users/nobody_m.96x96.jpg", userProfile.getPhotoUrls().getSize_96x96());
		assertEquals("http://www.xing.com/assets/frontend_minified/img/users/nobody_m.128x128.jpg", userProfile.getPhotoUrls().getSize_128x128());
		assertEquals("http://www.xing.com/assets/frontend_minified/img/users/nobody_m.192x192.jpg", userProfile.getPhotoUrls().getSize_192x192());
		assertEquals("http://www.xing.com/assets/frontend_minified/img/users/nobody_m.256x256.jpg", userProfile.getPhotoUrls().getSize_256x256());
		assertEquals("http://www.xing.com/assets/frontend_minified/img/users/nobody_m.1024x1024.jpg", userProfile.getPhotoUrls().getSize_1024x1024());
		assertEquals("http://www.xing.com/assets/frontend_minified/img/users/nobody_m.original.jpg", userProfile.getPhotoUrls().getSize_Original());

	}

	@Test
	public void getFullUserProfile() {
		mockServer.expect(requestTo(XingTemplate.DEFAULT_BASE_URL + ProfileTemplate.USERS_URL.replaceFirst("\\{id\\}", "me"))).andExpect(method(GET))
				.andRespond(withSuccess(new ClassPathResource("testdata/full_profile.json", getClass()), MediaType.APPLICATION_JSON));
		XingProfile userProfile = xing.profileOperations().getUserProfile();
		assertEquals(4, userProfile.getLanguages().size());
		assertEquals("ACM, GI", userProfile.getOrganisationMember());
		assertEquals("m", userProfile.getGender());

		List<String> badges = userProfile.getBadges();
		assertEquals(2, badges.size());
		assertEquals("PREMIUM", badges.get(0));
		assertEquals("MODERATOR", badges.get(1));

		assertEquals("max.mustermann@xing.com", userProfile.getActiveEmail());
		assertThat(userProfile.getEducationalBackground(), is(not(nullValue())));
		assertEquals("1_abcdef", userProfile.getProfessionalExperience().getPrimaryCompany().getId());
		assertEquals(Boolean.TRUE, userProfile.getProfessionalExperience().getPrimaryCompany().getUntilNow());
		assertEquals(EmploymentStatus.EMPLOYEE, userProfile.getEmploymentStatus());
		assertEquals(FormOfEmployment.FULL_TIME_EMPLOYEE, userProfile.getProfessionalExperience().getPrimaryCompany().getFormOfEmployment());
		assertEquals("42_abcdef", userProfile.getEducationalBackground().getPrimarySchool().getId());
		assertEquals(2, userProfile.getEducationalBackground().getQualifications().size());
		assertEquals("PADI AOWD", userProfile.getEducationalBackground().getQualifications().get(1));
		assertEquals(4, userProfile.getProfessionalExperience().getCompanies().size());

        assertEquals("max.mustermann@xing.com", userProfile.getActiveEmail());
        assertThat(userProfile.getEducationalBackground(), is(not(nullValue())));
        assertEquals("1_abcdef", userProfile.getProfessionalExperience().getPrimaryCompany().getId());
        assertEquals(Boolean.TRUE, userProfile.getProfessionalExperience().getPrimaryCompany().getUntilNow());
        assertEquals(EmploymentStatus.EMPLOYEE, userProfile.getEmploymentStatus());
        assertEquals(FormOfEmployment.FULL_TIME_EMPLOYEE, userProfile.getProfessionalExperience().getPrimaryCompany().getFormOfEmployment());
        assertEquals("42_abcdef", userProfile.getEducationalBackground().getPrimarySchool().getId());
        assertEquals(2, userProfile.getEducationalBackground().getQualifications().size());
        assertEquals("PADI AOWD", userProfile.getEducationalBackground().getQualifications().get(1));
        assertEquals(4, userProfile.getProfessionalExperience().getCompanies().size());
        assertEquals("max@mustermann.de", userProfile.getPrivateAddress().getEmail());
       // assertThat(userProfile.getWebProfiles().getBlog(), CoreMatchers.is());
	}

	@Test
	public void getProfileId() {
		mockServer.expect(requestTo(XingTemplate.DEFAULT_BASE_URL + ProfileTemplate.USERS_URL.replaceFirst("\\{id\\}", "me"))).andExpect(method(GET))
				.andRespond(withSuccess(new ClassPathResource("testdata/profile.json", getClass()), MediaType.APPLICATION_JSON));
		assertEquals("6628146_33f97b", xing.profileOperations().getProfileId());
	}

	@Test
	public void fullProfilFieldsAsString() throws Exception {
		System.out.println(ProfileTemplate.FULL_PROFILE_FIELDS);
		assertThat(ProfileTemplate.FULL_PROFILE_FIELDS.contains("first_name"), CoreMatchers.is(true));

	}
}
