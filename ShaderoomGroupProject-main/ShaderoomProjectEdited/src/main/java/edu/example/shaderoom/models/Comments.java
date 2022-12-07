package edu.example.shaderoom.models;

import java.util.Date;

public class Comments extends BaseComments{

    private User author;
    private Chats chats;

    public Comments()
    {

    }

    public Comments(String objectId, Number likeCount, String content, Date createdAt, User author, Chats chats)
    {
        this.objectId = objectId;
        this.likeCount = likeCount;
        this.content = content;
        this.createdAt = createdAt;
        this.author = author;
        this.chats = chats;
    }

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
