package org.springframework.social.xing.api;

public class TimeZone {

    private String name;
    private Double utcOffset;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getUtcOffset() {
        return utcOffset;
    }

    public void setUtcOffset(Double utcOffset) {
        this.utcOffset = utcOffset;
    }

}