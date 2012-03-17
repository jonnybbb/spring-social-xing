package org.springframework.social.xing.api;


import java.io.Serializable;

public class PhotoUrls implements Serializable{

    private static final long serialVersionUID = 1379041303608063601L;
    private String thumb;
    private String miniThumb;
    private String mediumThumb;
    private String maxiThumb;
    private String large;


    public String getMediumThumb() {
        return mediumThumb;
    }

    public void setMediumThumb(String mediumThumb) {
        this.mediumThumb = mediumThumb;
    }

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public String getMiniThumb() {
        return miniThumb;
    }

    public void setMiniThumb(String miniThumb) {
        this.miniThumb = miniThumb;
    }

    public String getMaxiThumb() {
        return maxiThumb;
    }

    public void setMaxiThumb(String maxiThumb) {
        this.maxiThumb = maxiThumb;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }

}
