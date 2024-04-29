package se.hakanostrom.stugan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.hakanostrom.stugan.entity.Bokning;
import se.hakanostrom.stugan.error.StuganResponseException;
import se.hakanostrom.stugan.service.BokningService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("bokning")
public class BokningController {


    @Autowired
    private BokningService bokningService;

    @Value("${api_key}")
    private String API_KEY;

    private static final String AUTH_TOKEN_HEADER_NAME = "API-KEY";

    // Hämtar en lista med bokningar. Dessa hämtas upp från databasen, och den har inga bokningar förpopulerada vid appstart.
    // Tillåt CORS helt och hållet (lite yxigt och ingen långsiktig strategi säkerhetsmässigt)
    @CrossOrigin("*")
    @GetMapping
    public ResponseEntity<List<Bokning>> getAll(@RequestHeader(value = AUTH_TOKEN_HEADER_NAME, required = false) String apikey) {

        // Borde hellre lösas med ett filter
        if (!API_KEY.equals(apikey))
            throw StuganResponseException.ogiltigNyckel();

        var res = bokningService.listaBokningar();

        return ResponseEntity.ok(res);
    }

    // Hämta en lista av bokningar per stuga (beroende på att frontendlistningen är upplagd på det sätt det är).
    // De anrop som administratören gör är skyddade av inloggning/apinyckel
    // Tillåt CORS helt och hållet (lite yxigt och ingen långsiktig strategi säkerhetsmässigt)
    @CrossOrigin("*")
    @GetMapping("stuga/{id}")
    public ResponseEntity<List<Bokning>> getByStuga(@RequestHeader(value = AUTH_TOKEN_HEADER_NAME) String apikey, @PathVariable Long id) {

        // Borde hellre lösas med ett filter
        if (!API_KEY.equals(apikey))
            throw StuganResponseException.ogiltigNyckel();

        var res = bokningService.listaBokningarPerStuga(id);

        return ResponseEntity.ok(res);
    }

    // Att skapa bokning skulle kunna vara en kandidat för att kräva apinyckel, men detta blev utscopeat.
    // Tillåt CORS helt och hållet (lite yxigt och ingen långsiktig strategi säkerhetsmässigt)
    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<Optional<Bokning>> create(@RequestBody Bokning bokning) {

        var res = bokningService.sparaBokning(bokning);

        if (res.isEmpty())
            throw StuganResponseException.dubbelbokat();
        else
            return ResponseEntity.ok(res);
    }
}
