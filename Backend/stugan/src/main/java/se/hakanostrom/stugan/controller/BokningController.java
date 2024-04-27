package se.hakanostrom.stugan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import se.hakanostrom.stugan.entity.Bokning;
import se.hakanostrom.stugan.repository.BokningRepository;
import se.hakanostrom.stugan.service.BokningService;

import java.util.List;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("bokning")
public class BokningController {

    @Autowired
    private BokningRepository bokningRepository;

    @Autowired
    private BokningService bokningService;

    @Value("${api_key}")
    private String API_KEY;

    private static final String AUTH_TOKEN_HEADER_NAME = "API-KEY";

    @CrossOrigin("*")
    @GetMapping
    public ResponseEntity<List<Bokning>> getAll(@RequestHeader(value = AUTH_TOKEN_HEADER_NAME, required = false) String apikey) {

        // Borde hellre lösas med ett filter
        if (!API_KEY.equals(apikey))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Ogiltigt eller ingen api-nyckel");

        var res = bokningService.listaBokningar();

        return ResponseEntity.ok(res);
    }

    @CrossOrigin("*")
    @GetMapping("stuga/{id}")
    public ResponseEntity<List<Bokning>> getByStuga(@RequestHeader(value = AUTH_TOKEN_HEADER_NAME) String apikey, @PathVariable Long id) {

        // Borde hellre lösas med ett filter
        if (!API_KEY.equals(apikey))
            throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "Ogiltigt eller ingen api-nyckel");

        log.info("Id på stuga att lista bokningar för: " + id);
        var res = bokningService.listaBokningarPerStuga(id);

        return ResponseEntity.ok(res);
    }

    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<Optional<Bokning>> create(@RequestBody Bokning bokning) {

        var res = bokningService.sparaBokning(bokning);

        if (res.isEmpty())
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Dubbelbokat! Det finns redan en bokning på denna stuga denna dag");
        else
            return ResponseEntity.ok(res);
    }
}
