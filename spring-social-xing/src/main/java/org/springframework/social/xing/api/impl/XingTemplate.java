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

import org.codehaus.jackson.JsonParser.Feature;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.map.SerializationConfig;
import org.codehaus.jackson.map.annotate.JsonSerialize;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.json.MappingJacksonHttpMessageConverter;
import org.springframework.social.oauth1.AbstractOAuth1ApiBinding;
import org.springframework.social.support.HttpRequestDecorator;
import org.springframework.social.xing.api.*;
import org.springframework.social.xing.api.impl.json.XingModule;
import org.springframework.util.ClassUtils;
import org.springframework.web.client.RestOperations;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

/**
 * This is the central class for interacting with Xing.
 * <p>
 * Greenhouse operations require OAuth authentication with the server.
 * Therefore, XingTemplate must be constructed with the minimal information
 * required to sign requests with and OAuth 1 Authorization header.
 * </p>
 * @author Craig Walls
 */
public class XingTemplate extends AbstractOAuth1ApiBinding implements Xing {
	
	/**
	 * Creates a new XingTemplate given the minimal amount of information needed to sign requests with OAuth 1 credentials.
	 * @param consumerKey the application's API key
	 * @param consumerSecret the application's API secret
	 * @param accessToken an access token acquired through OAuth authentication with Xing
	 * @param accessTokenSecret an access token secret acquired through OAuth authentication with Xing
	 */
	public XingTemplate(String consumerKey, String consumerSecret, String accessToken, String accessTokenSecret) {
		super(consumerKey, consumerSecret, accessToken, accessTokenSecret);
		registerLinkedInJsonModule();
		registerJsonFormatInterceptor();
		initSubApis();
	}


	public ProfileOperations profileOperations() {
		return profileOperations;
	}
	

	
	public RestOperations restOperations() {
		return getRestTemplate();
	}
	
	// private helpers
	
	private void registerLinkedInJsonModule() {
		List<HttpMessageConverter<?>> converters = getRestTemplate().getMessageConverters();
		for (HttpMessageConverter<?> converter : converters) {
			if(converter instanceof MappingJacksonHttpMessageConverter) {
				MappingJacksonHttpMessageConverter jsonConverter = (MappingJacksonHttpMessageConverter) converter;
				objectMapper = new ObjectMapper();				
				objectMapper.registerModule(new XingModule());
				objectMapper.configure(SerializationConfig.Feature.WRITE_ENUMS_USING_TO_STRING, true);
				objectMapper.configure(Feature.ALLOW_NUMERIC_LEADING_ZEROS, true);
				objectMapper.setSerializationConfig(objectMapper.getSerializationConfig().withSerializationInclusion(JsonSerialize.Inclusion.NON_NULL));
				jsonConverter.setObjectMapper(objectMapper);
			}
		}
	}
	
	/*
	 * Have to register custom interceptor to
	 * set  "x-li-format: "json" header as
	 * otherwise we appear to get error from xing
	 * which suggests its expecting xml rather than json.
	 * API appears to ignore Content-Type header
	 */
	private void registerJsonFormatInterceptor() {		
		RestTemplate restTemplate = getRestTemplate();
		if (interceptorsSupported) {
			List<ClientHttpRequestInterceptor> interceptors = restTemplate.getInterceptors();
			interceptors.add(new JsonFormatInterceptor());
		} else {
			// for Spring 3.0.x where interceptors aren't supported
			ClientHttpRequestFactory originalRequestFactory = restTemplate.getRequestFactory();
			JsonFormatHeaderRequestFactory newRequestFactory = new JsonFormatHeaderRequestFactory(originalRequestFactory);
			restTemplate.setRequestFactory(newRequestFactory);
		}
	}
	
	private void initSubApis() {
		profileOperations = new ProfileTemplate(getRestTemplate(), objectMapper);

	}

	private ProfileOperations profileOperations;

	

	private ObjectMapper objectMapper;
	
	private static boolean interceptorsSupported = ClassUtils.isPresent("org.springframework.http.client.ClientHttpRequestInterceptor", XingTemplate.class.getClassLoader());
	
	static final String BASE_URL = "https://api.xing.com/v1";
	
	private static final class JsonFormatInterceptor implements ClientHttpRequestInterceptor {
		public ClientHttpResponse intercept(HttpRequest request, byte[] body,
				ClientHttpRequestExecution execution) throws IOException {
			HttpRequest contentTypeResourceRequest = new HttpRequestDecorator(request);
			contentTypeResourceRequest.getHeaders().add("x-li-format", "json");
			return execution.execute(contentTypeResourceRequest, body);
		}
		
	}

}
