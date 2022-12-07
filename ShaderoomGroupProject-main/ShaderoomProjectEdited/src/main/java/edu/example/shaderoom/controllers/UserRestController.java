package edu.example.shaderoom.controllers;

import edu.example.shaderoom.models.Chats;
import edu.example.shaderoom.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.ExecutionException;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    public UserService userService;

    @Autowired
    public UserRestController(UserService userService){
        this.userService= userService;
    }

    @GetMapping("/{id}/chats")
    public List<Chats> getChatsByUserId(@PathVariable (name="id") String id) throws ExecutionException, InterruptedException
    {
        return userService.getChatsByUserId(id);
    }
}
