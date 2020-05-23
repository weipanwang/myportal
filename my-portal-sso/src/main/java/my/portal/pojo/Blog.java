package my.portal.pojo;

import java.util.Date;

public class Blog {
    private int blogId;

    private String blogTitle;

    private String blogAuthor;

    private String blogPhoto;

    private String blogSort;

    private int blogSeeNumber;

    private int blogCommentNumber;

    private Date blogCreated;

    private Date blogUpdated;

    public int getBlogId() {
        return blogId;
    }

    public void setBlogId(int blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle == null ? null : blogTitle.trim();
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor == null ? null : blogAuthor.trim();
    }

    public String getBlogPhoto() {
        return blogPhoto;
    }

    public void setBlogPhoto(String blogPhoto) {
        this.blogPhoto = blogPhoto == null ? null : blogPhoto.trim();
    }

    public String getBlogSort() {
        return blogSort;
    }

    public void setBlogSort(String blogSort) {
        this.blogSort = blogSort == null ? null : blogSort.trim();
    }

    public int getBlogSeeNumber() {
        return blogSeeNumber;
    }

    public void setBlogSeeNumber(int blogSeeNumber) {
        this.blogSeeNumber = blogSeeNumber;
    }

    public int getBlogCommentNumber() {
        return blogCommentNumber;
    }

    public void setBlogCommentNumber(int blogCommentNumber) {
        this.blogCommentNumber = blogCommentNumber;
    }

    public Date getBlogCreated() {
        return blogCreated;
    }

    public void setBlogCreated(Date blogCreated) {
        this.blogCreated = blogCreated;
    }

    public Date getBlogUpdated() {
        return blogUpdated;
    }

    public void setBlogUpdated(Date blogUpdated) {
        this.blogUpdated = blogUpdated;
    }
}