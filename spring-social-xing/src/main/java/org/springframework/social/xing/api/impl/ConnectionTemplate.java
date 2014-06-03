package org.springframework.social.xing.api.impl;

import org.springframework.social.support.URIBuilder;
import org.springframework.social.xing.api.ConnectionOperations;
import org.springframework.social.xing.api.XingConnections;
import org.springframework.social.xing.api.XingProfile;
import org.springframework.web.client.RestOperations;

import java.net.URI;
import java.util.List;

/**
 *
 */
public class ConnectionTemplate extends AbstractTemplate implements ConnectionOperations {

    static final String CONNECTIONS_URL = XingTemplate.BASE_URL + "/users/{id}/contacts";
    static final String CONNECTIONS_URL2 = XingTemplate.BASE_URL + "/users/me/contacts";


    private final RestOperations restOperations;

    public ConnectionTemplate(RestOperations restOperations) {
        this.restOperations = restOperations;
    }

    public List<XingProfile> getConnections() {
        XingConnections connections = restOperations.getForObject(CONNECTIONS_URL, XingConnections.class,"me");
        return connections.getContacts().getUsers();
    }

    public List<XingProfile> getConnections(String id) {
        XingConnections connections = restOperations.getForObject(CONNECTIONS_URL, XingConnections.class,id);
        return connections.getContacts().getUsers();
    }

    @Override
    public List<XingProfile> getConnectionWithProfil() {
        URI uri = URIBuilder.fromUri(CONNECTIONS_URL2)
                .queryParam("user_fields", ProfileTemplate.FULL_PROFILE_FIELDS)
                .build();
        XingConnections connections = restOperations.getForObject(uri, XingConnections.class);
        return connections.getContacts().getUsers();
    }

    public List<XingProfile> getConnections(int start, int count) {
        URI uri = URIBuilder.fromUri(CONNECTIONS_URL)
                .queryParam("offset", String.valueOf(start))
                .queryParam("limit", String.valueOf(count)).build();
        XingConnections connections = restOperations.getForObject(uri, XingConnections.class);
        return connections.getContacts().getUsers();
    }
}
