package edu.example.shaderoom.models;

public abstract class BaseComments
{
    @DocumentId
    protected String objectId;
    protected String content;
    protected Number likeCount;
    protected Date createdAt;

    public String getObjectId() {
        return objectId;
    }

    public void setObjectId(String objectId) {
        this.objectId = objectId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Number getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(Number likeCount) {
        this.likeCount = likeCount;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }
}
