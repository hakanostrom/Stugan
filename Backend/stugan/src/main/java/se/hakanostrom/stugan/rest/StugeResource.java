package se.hakanostrom.stugan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import se.hakanostrom.stugan.entity.Stuga;
import se.hakanostrom.stugan.service.StugaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("stuga")
public class StugeResource {

    @Autowired
    private StugaService stugaService;

    @CrossOrigin("*")
    @GetMapping
    public ResponseEntity<List<Stuga>> getAll() {

        var res = stugaService.listaStugor();

        return ResponseEntity.ok(res);
    }

    @CrossOrigin("*")
    @GetMapping("{id}")
    public ResponseEntity<Optional<Stuga>> findById(@PathVariable("id") Long id) {
        return ResponseEntity.of(Optional.ofNullable(stugaService.hittaStuga(id)));
    }
}
