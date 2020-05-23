package my.portal.pojo;

import java.util.Date;

public class Sort {
    private Long sortId;

    private Long parentId;

    private String sortName;

    private Date sortCreated;

    private Date sortUpdated;

    public Long getSortId() {
        return sortId;
    }

    public void setSortId(Long sortId) {
        this.sortId = sortId;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    public String getSortName() {
        return sortName;
    }

    public void setSortName(String sortName) {
        this.sortName = sortName == null ? null : sortName.trim();
    }

    public Date getSortCreated() {
        return sortCreated;
    }

    public void setSortCreated(Date sortCreated) {
        this.sortCreated = sortCreated;
    }

    public Date getSortUpdated() {
        return sortUpdated;
    }

    public void setSortUpdated(Date sortUpdated) {
        this.sortUpdated = sortUpdated;
    }
}