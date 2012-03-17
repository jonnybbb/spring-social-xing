package org.springframework.social.xing.api;

import java.io.Serializable;

public class BirthDate implements Serializable {

    private static final long serialVersionUID = -4246513491965468863L;
    private Long day;
    private Long year;
    private Long month;

    public BirthDate(Long day, Long year, Long month) {
        this.day = day;
        this.year = year;
        this.month = month;
    }

    public Long getDay() {
        return day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public Long getYear() {
        return year;
    }

    public void setYear(Long year) {
        this.year = year;
    }

    public Long getMonth() {
        return month;
    }

    public void setMonth(Long month) {
        this.month = month;
    }

}
