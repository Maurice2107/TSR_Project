package edu.example.shaderoom.models;

import java.util.Date;

public class Chat extends BaseChat
{
    private User author;

    public Chat()
    {

    }

    public Chat(String objectId, String title, String content, Date createdAt, User author, String topic)
    {
        this.objectId = objectId;
        this.title = title;
        this.content = content;
        this.createdAt = createdAt;
        this.topic = topic;
        this.author = author;

    }



    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }
}
