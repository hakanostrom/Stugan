package se.hakanostrom.stugan.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class StugaServiceImplTest {

    private final int PREPOPLATE_COUNT = 5;

    @Autowired
    private StugaService stugaService;

    @Test
    void testPrePopulated() {
        var stugaCount = stugaService.listaStugor().size();
        assertEquals(PREPOPLATE_COUNT, stugaCount);
    }
}