package my.portal.pojo;

public class BlogWithBLOBs extends Blog {
    private String blogBody;

    private String blogComment;

    public String getBlogBody() {
        return blogBody;
    }

    public void setBlogBody(String blogBody) {
        this.blogBody = blogBody == null ? null : blogBody.trim();
    }

    public String getBlogComment() {
        return blogComment;
    }

    public void setBlogComment(String blogComment) {
        this.blogComment = blogComment == null ? null : blogComment.trim();
    }
}