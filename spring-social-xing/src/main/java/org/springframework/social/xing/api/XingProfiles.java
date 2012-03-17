package org.springframework.social.xing.api;

import java.io.Serializable;
import java.util.List;

public class XingProfiles implements Serializable {

    private static final long serialVersionUID = -8787090599885028919L;
    private List<XingProfile> profiles;


    public XingProfiles(List<XingProfile> profiles) {
        this.profiles = profiles;
    }

    public List<XingProfile> getProfiles() {
        return profiles;
    }
}
