package se.hakanostrom.stugan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

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
    public ResponseEntity<String> login(@RequestParam String user, @RequestParam String pass) {

        if (ADMIN_USER.equals(user) && ADMIN_PASS.equals(pass))
            return ResponseEntity.ok(API_KEY);
        else
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
