package se.hakanostrom.stugan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {

    @Value("${admin_user}")
    private String ADMIN_USER;

    @Value("${admin_pass}")
    private String ADMIN_PASS;

    @Value("${api_key}")
    private String API_KEY;

    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<String> login(@RequestParam Optional<String> user, @RequestParam Optional<String> pass) {

        if (!ADMIN_USER.equals(user.orElse("")) || !ADMIN_PASS.equals(pass.orElse("")))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Ogiltigt användarnamn och lösenod");
      
        return ResponseEntity.ok(API_KEY);

    }
}
