package org.springframework.social.xing.api;

import java.util.List;

public interface ConnectionOperations {

    /**
     * Retrieves up to 500 of the 1st-degree connections from the current user's network.
     * @return the user's connections
     */
    List<User> getConnections();

    List<User> getConnections(String id);

    /**
     * Retrieves the 1st-degree connections from the current user's network.
     * @param start The starting location in the result set. Used with count for pagination.
     * @param count The number of connections to return. The maximum value is 500. Used with start for pagination.
     * @return the user's connections
     */
    List<User> getConnections(int start, int count);


}