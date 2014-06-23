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

/**
 * Operations on Profile API
 * 
 * @author Robert Drysdale
 */
public interface ProfileOperations {

	/**
	 * Retrieves the user's Xing profile ID.
	 * 
	 * @return the user's Xing profile ID.
	 */
	String getProfileId();

    /**
	 * Retrieves the current user's profile details.
	 * 
	 * @return the user's profile data.
	 */
	XingProfile getUserProfile();
	
	/**
	 * Retrieves a profile by id.
	 * 
	 * @return the user's profile data.
	 */
	XingProfile getProfileById(String id);

}
