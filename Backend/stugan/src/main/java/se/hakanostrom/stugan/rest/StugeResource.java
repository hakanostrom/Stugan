package se.hakanostrom.stugan.rest;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import se.hakanostrom.stugan.entity.Stuga;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("stuga")
public class StugeResource {

    @CrossOrigin("*")
    @GetMapping
    public ResponseEntity<List<Stuga>> getAll() {

        var res = new ArrayList<Stuga>(Collections.emptyList());
        var stuga = new Stuga();
        stuga.setName("Storstugan");
        res.add(stuga);
        var stuga2 = new Stuga();
        stuga2.setName("Lillstugan");
        res.add(stuga2);

        return ResponseEntity.ok(res);
    }
}
