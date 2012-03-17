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
package org.springframework.social.xing.connect;

import org.junit.Test;
import org.mockito.Mockito;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.xing.api.ProfileOperations;
import org.springframework.social.xing.api.Xing;
import org.springframework.social.xing.api.XingProfile;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class XingAdapterTest {

	private XingAdapter apiAdapter = new XingAdapter();
	
	private Xing xing = Mockito.mock(Xing.class);
	
	@Test
	public void fetchProfile() {
		ProfileOperations profileOperations = Mockito.mock(ProfileOperations.class);
		Mockito.when(xing.profileOperations()).thenReturn(profileOperations);
		Mockito.when(profileOperations.getUserProfile()).thenReturn(new XingProfile("50A3nOf73z", "Johannes", "Bühler",
                "https://www.xing.com/profile/Johannes_Buehler","johannesbuehler@oderbruecke.de","Johannes_Buehler"));
		UserProfile profile = apiAdapter.fetchUserProfile(xing);
		assertEquals("Johannes Bühler", profile.getName());
		assertEquals("Johannes", profile.getFirstName());
		assertEquals("Bühler", profile.getLastName());
		assertNull(profile.getEmail());
		assertNull(profile.getUsername());
	}

}
