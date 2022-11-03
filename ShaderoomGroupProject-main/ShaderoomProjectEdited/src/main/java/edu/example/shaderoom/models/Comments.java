package edu.example.shaderoom.models;

public class Comments extends BaseComments{

    private User author;

    public Comments()
    {

    }

    public Comments(String objectId, Number likeCount, String content, Date createdAt)
    {
        this.objectId = objectId;
        this.likeCount = likeCount;
        this.content = content;
        this.createdAt = createdAt;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
