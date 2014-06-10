package org.springframework.social.xing.api;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 *
 */
public abstract class XingObject implements Serializable {
    private Map<String, Object> extraData;

    public XingObject() {
        this.extraData = new HashMap<String, Object>();
    }

    /**
     * @return Any fields in response from LinkedIn that are otherwise not mapped to any properties.
     */
    public Map<String, Object> getExtraData() {
        return extraData;
    }

    /**
     * {@link com.fasterxml.jackson.annotation.JsonAnySetter} hook. Called when an otherwise unmapped property is being processed during JSON deserialization.
     * @param key The property's key.
     * @param value The property's value.
     */
    protected void add(String key, Object value) {
        extraData.put(key, value);
    }

}
