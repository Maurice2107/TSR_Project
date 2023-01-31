package edu.example.shaderoom.controllers;

import edu.example.shaderoom.auth.services.SecurityService;
import edu.example.shaderoom.models.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.Collections;

@Controller
public class AuthenticationController {

    @GetMapping("/login")
    public String getLogin()
    {
        return "login";
    }


    /**
     * Used to create the session. Does not retun a template like most controllers
     */
    @GetMapping("/session")
    public ResponseEntity createSession()
    {
        SecurityService securityService = new SecurityService();
        User user = securityService.getUser().getUser();

        //return the customer object in JSON format
        return ResponseEntity.ok(Collections.singletonMap("user", user));
    }
}
