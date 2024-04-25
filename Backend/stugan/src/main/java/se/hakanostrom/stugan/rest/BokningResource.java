package se.hakanostrom.stugan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.hakanostrom.stugan.entity.Bokning;
import se.hakanostrom.stugan.repository.BokningRepository;
import se.hakanostrom.stugan.service.BokningService;

import java.util.List;

@RestController
@RequestMapping("bokning")
public class BokningResource {

    @Autowired
    private BokningRepository bokningRepository;

    @Autowired
    private BokningService bokningService;

    @CrossOrigin("*")
    @GetMapping
    public ResponseEntity<List<Bokning>> getAll() {

        var res = bokningService.listaBokningar();

        return ResponseEntity.ok(res);
    }

    @CrossOrigin("*")
    @PostMapping
    public ResponseEntity<Bokning> create(@RequestBody Bokning bokning) {

        var res = bokningService.sparaBokning(bokning);

        return ResponseEntity.ok(res);
    }
}
