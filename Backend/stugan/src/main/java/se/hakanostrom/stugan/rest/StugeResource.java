package se.hakanostrom.stugan.rest;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("stuga")
public class StugeResource {

    @CrossOrigin("*")
    @GetMapping
    public String getAll() {

        return "Hello from Stugan";
    }
}
