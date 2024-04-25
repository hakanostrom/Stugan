package se.hakanostrom.stugan.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.hakanostrom.stugan.entity.Bokning;
import se.hakanostrom.stugan.repository.BokningRepository;
import se.hakanostrom.stugan.service.BokningService;

import java.util.List;

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
        if (apikey == null || !apikey.equals(API_KEY))
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        var res = bokningService.listaBokningar();

        return ResponseEntity.ok(res);
    }

    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<Bokning> create(@RequestBody Bokning bokning) {

        log.info("Före");
        var res = bokningService.sparaBokning(bokning);
        log.info("efter");

        return ResponseEntity.ok(res);
    }
}
