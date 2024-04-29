package se.hakanostrom.stugan.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.hakanostrom.stugan.error.StuganResponseException;

import java.util.Optional;

@RestController
@RequestMapping("auth")
public class AuthController {

    // Läs in inloggningsuppgifter från application.properties
    // Nu finns det bara EN admin med EN apinyckel. Kanske inte så skalbart eller praktiskt i övrigt att ha det hårdkodat.

    @Value("${admin_user}")
    private String ADMIN_USER;

    @Value("${admin_pass}")
    private String ADMIN_PASS;

    @Value("${api_key}")
    private String API_KEY;

    // Tillåt CORS helt och hållet (lite yxigt och ingen långsiktig strategi säkerhetsmässigt)
    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<String> login(@RequestParam Optional<String> user, @RequestParam Optional<String> pass) {

        // Ett mer hållbart sätt (istället för att skicka lösenord i klartext) skulle kunna vara att skicka inloggningsuppgifter
        // i body eller hashat i header
        if (!ADMIN_USER.equals(user.orElse("")) || !ADMIN_PASS.equals(pass.orElse("")))
            throw StuganResponseException.ogiltigLogin();

        return ResponseEntity.ok(API_KEY);

    }
}
