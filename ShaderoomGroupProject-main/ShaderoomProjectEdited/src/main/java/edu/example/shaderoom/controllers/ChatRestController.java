package edu.example.shaderoom.controllers;


import edu.example.shaderoom.models.Chat;
import edu.example.shaderoom.models.Comment;
import edu.example.shaderoom.models.RestChats;
import edu.example.shaderoom.services.ChatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping ("/api/chats")
public class ChatRestController {

    public ChatService chatService;

    @Autowired
    public ChatRestController(ChatService chatService)
    {
        this.chatService = chatService;
    }

    @GetMapping("/{id}")
    public List<Comment> getChatById(@PathVariable(name="id") String id) throws ExecutionException, InterruptedException {
        return chatService.getChatsComments(id);
    }

    @GetMapping("/{string}")
    public List<Chat> getChatByTopic(@PathVariable(name="topic") String topic) throws ExecutionException, InterruptedException {
        return chatService.getChatsTopic(topic);
    }
    @PostMapping ("/")
    public String createChat(@RequestBody RestChats chats) throws ExecutionException, InterruptedException {
        return chatService.createPost(chats);
    }
}
