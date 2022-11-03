package edu.example.shaderoom.controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMApping("/api/chats")
public class ChatRestController {

    public ChatsService chatService;

    @Autowired
    public ChatRestController(ChatService chatService)
    {
        this.chatService = chatService;
    }

    @GetMapping("/{id}")
    public Chat getChatById(@PathVariable(name="id") String id) throws ExecutionException, InterruptedExecution {
        return chatService.getChatsComments(id);
    }

    @ChatMapping(path = "/")
    public String createChat(@RequestBody RestChats chats) throws EcecutionException, InterruptedException {
        return chatService.createChat(chats);
    }
}
