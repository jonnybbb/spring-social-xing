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
import org.springframework.social.xing.api.XingProfile;

import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;
import static org.springframework.http.HttpMethod.GET;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * @author Johannes Buehler
 */
public class ConnectionTemplateTest extends AbstractXingApiTest {

    @Test
    public void getConections() {
        mockServer.expect(requestTo(XingTemplate.DEFAULT_BASE_URL + ConnectionTemplate.CONNECTIONS_URL.replaceFirst("\\{id\\}", "me"))).andExpect(method(GET))
                .andRespond(withSuccess(new ClassPathResource("testdata/connections.json", getClass()), MediaType.APPLICATION_JSON));
        List<XingProfile> profiles = xing.connectionOperations().getConnections();
        assertThat(profiles, hasSize(10));
        for (XingProfile profile : profiles) {
            assertThat(profile.getId().length(), is(greaterThan(1)));
        }
    }


    @Test
    public void getConectionsWithProfil() {
        mockServer.expect(requestTo(XingTemplate.DEFAULT_BASE_URL + ConnectionTemplate.CONNECTIONS_URL.replaceFirst("\\{id\\}", "me"))).andExpect(method(GET))
                .andRespond(withSuccess(new ClassPathResource("testdata/connections_with_fields.json", getClass()), MediaType.APPLICATION_JSON));
        List<XingProfile> profiles = xing.connectionOperations().getConnections();
        assertThat(profiles, hasSize(5));
        for (XingProfile profile : profiles) {
            assertThat(profile.getId().length(), is(greaterThan(1)));
            assertThat(profile.getDisplayName().length(), is(greaterThan(1)));
        }
    }
}
