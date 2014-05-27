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

import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;
import org.springframework.social.connect.UserProfileBuilder;
import org.springframework.social.xing.api.Xing;
import org.springframework.social.xing.api.XingProfile;
import org.springframework.web.client.HttpClientErrorException;

/**
 * Xing ApiAdapter implementation.
 * @author Johannes Buehler
 */
public class XingAdapter implements ApiAdapter<Xing> {

	public boolean test(Xing xing) {
		try {
			xing.profileOperations().getUserProfile();
			return true;
		} catch (HttpClientErrorException e) {
			// TODO: Have api throw more specific exception and trigger off of that.
			return false;
		}
	}

	public void setConnectionValues(Xing xing, ConnectionValues values) {
		XingProfile profile = xing.profileOperations().getUserProfile();
		values.setProviderUserId(profile.getId());
        values.setImageUrl(profile.getPhotoUrls().getThumb());
        values.setProfileUrl(profile.getPermalink());
		values.setDisplayName(profile.getFirstName() + " " + profile.getLastName());
	}

	public UserProfile fetchUserProfile(Xing xing) {
		XingProfile profile = xing.profileOperations().getUserProfile();
		return new UserProfileBuilder()
                .setName(profile.getFirstName() + " " + profile.getLastName())
                .setEmail(profile.getActiveEmail()).build();
	}
	
	public void updateStatus(Xing xing, String message) {
		// not supported yet
	}
	
}
