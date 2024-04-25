package se.hakanostrom.stugan.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.hakanostrom.stugan.entity.Stuga;
import se.hakanostrom.stugan.service.StugaService;

import java.util.List;

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
}
