package edu.example.shaderoom.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/user")
public class UserRestController {

    public UserService userService;

    @Autowired
    public UserRestCOntroller(USerService userService){
        this.userServicee= userService;
    }

    @GetMapping("/{id}/chats")
    public List<Chats> getChatsByUserId(@PAthVariable(name="id") String id) throws ExecutionException, InterruptedExcecution
    {
        return userService.getChatsByUserId(id);
    }
}
