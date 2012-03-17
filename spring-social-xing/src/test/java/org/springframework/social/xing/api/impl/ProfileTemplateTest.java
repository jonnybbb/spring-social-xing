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
import org.springframework.social.xing.api.XingProfile;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.RequestMatchers.method;
import static org.springframework.test.web.client.RequestMatchers.requestTo;
import static org.springframework.test.web.client.ResponseCreators.withResponse;

/**
 * @author Craig Walls
 */
public class ProfileTemplateTest extends AbstractXingApiTest {

	@Test
	public void getUserProfile() {
		mockServer.expect(requestTo(ProfileTemplate.USERS_URL.replaceFirst("\\{id\\}","me"))).andExpect(method(GET))
				.andRespond(withResponse(new ClassPathResource("testdata/profile.json", getClass()), responseHeaders));
		XingProfile userProfile = xing.profileOperations().getUserProfile();
		assertEquals("6628146_33f97b", userProfile.getId());
		assertEquals("Johannes", userProfile.getFirstName());
		assertEquals("Bühler", userProfile.getLastName());
        assertThat(userProfile.getPermalink(), is(not(nullValue())));
	}
	

	@Test
	public void getProfileId() {
		mockServer.expect(requestTo(ProfileTemplate.USERS_URL.replaceFirst("\\{id\\}","me"))).andExpect(method(GET))
				.andRespond(withResponse(new ClassPathResource("testdata/profile.json", getClass()), responseHeaders));
		assertEquals("6628146_33f97b", xing.profileOperations().getProfileId());
	}
}
