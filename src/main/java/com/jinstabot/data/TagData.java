package com.jinstabot.data;

import org.openqa.selenium.WebElement;

/**
 * @author Alex L.
 */
public class TagData implements Data{

    private String tag;

    private String link;

    private WebElement likeElement;

    private WebElement likedElement;

    private String comment;

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public WebElement getLikeElement() {
        return likeElement;
    }

    public void setLikeElement(WebElement likeElement) {
        this.likeElement = likeElement;
    }

    public WebElement getLikedElement() {
        return likedElement;
    }

    public void setLikedElement(WebElement likedElement) {
        this.likedElement = likedElement;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }
}
