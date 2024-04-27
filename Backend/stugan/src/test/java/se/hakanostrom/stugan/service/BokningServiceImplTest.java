package se.hakanostrom.stugan.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import se.hakanostrom.stugan.entity.Bokning;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest
class BokningServiceImplTest {

    private final Long BOKNING_ID = 1L;
    private final String BOKNING_DATUM = "2024-04-27";
    private final String BOKNING_DATUM2 = "2024-05-27";
    private final Long BOKNING_STUGID = 2L;
    private final String BOKNING_NAMN = "Lars Larsson";
    private final String BOKNING_TELEFON = "070-12345";
    private final String BOKNING_EPOST = "test@example.com";

    private Bokning bokning;

    @Autowired
    BokningService bokningService;

    @BeforeEach
    void setUp() {
        bokning = new Bokning()
                .setID(BOKNING_ID)
                .setStuga_id(BOKNING_STUGID)
                .setDatum(BOKNING_DATUM)
                .setNamn(BOKNING_NAMN)
                .setTelefon(BOKNING_TELEFON)
                .setEpost(BOKNING_EPOST);
    }

    @Test
    void testDubbelbokning() {

        assertFalse(bokningService.sparaBokning(bokning).isEmpty());
        assertTrue(bokningService.sparaBokning(bokning).isEmpty());

        Bokning bokning2 = new Bokning()
                .setID(BOKNING_ID)
                .setStuga_id(BOKNING_STUGID)
                .setDatum(BOKNING_DATUM2)
                .setNamn(BOKNING_NAMN)
                .setTelefon(BOKNING_TELEFON)
                .setEpost(BOKNING_EPOST);

        assertFalse(bokningService.sparaBokning(bokning2).isEmpty());
    }
}