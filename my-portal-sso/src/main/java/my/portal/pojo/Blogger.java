package my.portal.pojo;

import java.util.Date;

public class Blogger {
    private Long bloggerId;

    private String bloggerName;

    private String bloggerCity;

    private String bloggerShow;

    private String bloggerHead;

    private Date created;

    private Date updated;

    public Long getBloggerId() {
        return bloggerId;
    }

    public void setBloggerId(Long bloggerId) {
        this.bloggerId = bloggerId;
    }

    public String getBloggerName() {
        return bloggerName;
    }

    public void setBloggerName(String bloggerName) {
        this.bloggerName = bloggerName == null ? null : bloggerName.trim();
    }

    public String getBloggerCity() {
        return bloggerCity;
    }

    public void setBloggerCity(String bloggerCity) {
        this.bloggerCity = bloggerCity == null ? null : bloggerCity.trim();
    }

    public String getBloggerShow() {
        return bloggerShow;
    }

    public void setBloggerShow(String bloggerShow) {
        this.bloggerShow = bloggerShow == null ? null : bloggerShow.trim();
    }

    public String getBloggerHead() {
        return bloggerHead;
    }

    public void setBloggerHead(String bloggerHead) {
        this.bloggerHead = bloggerHead == null ? null : bloggerHead.trim();
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}