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

import org.springframework.social.ApiBinding;
import org.springframework.web.client.RestOperations;

/**
 * Interface specifying a basic set of operations for interacting with Xing. Implemented by {@link org.springframework.social.xing.api.impl.XingTemplate}.
 * Many of the methods contained in this interface require OAuth authentication with Xing.
 * When a method's description speaks of the "current user", it is referring to the user for whom the access token has been issued.
 * 
 * @author Craig Walls
 * @author Robert Drysdale
 */
public interface Xing extends ApiBinding {

	/**
	 * API for retrieving and performing operations on profiles
	 */
	ProfileOperations profileOperations();
	


	/**
	 * Returns the underlying {@link RestOperations} object allowing for consumption of Xing endpoints that may not be otherwise covered by the API binding.
	 * The RestOperations object returned is configured to include an OAuth "Authorization" header on all requests.
	 */
	RestOperations restOperations();
	
}
