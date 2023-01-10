package edu.example.shaderoom.models;

import java.util.Date;

public class Comment extends BaseComment {

    private User author;
    private Chat chats;

    public Comment()
    {

    }

    public Comment(String objectId, Number likeCount, String content, Date createdAt, User author, Chat chats)
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
