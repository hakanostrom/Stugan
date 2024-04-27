package se.hakanostrom.stugan.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BokningTest {

    private final Long BOKNING_ID = 1L;
    private final String BOKNING_DATUM = "2024-04-27";
    private final Long BOKNING_STUGID = 2L;
    private final String BOKNING_NAMN = "Lars Larsson";
    private final String BOKNING_TELEFON = "070-12345";
    private final String BOKNING_EPOST = "test@example.com";

    private Bokning bokning;

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
    void testGetterSetter() {
        assertEquals(BOKNING_ID, bokning.getID());
        assertEquals(BOKNING_STUGID, bokning.getStuga_id());
        assertEquals(BOKNING_DATUM, bokning.getDatum());
        assertEquals(BOKNING_NAMN, bokning.getNamn());
        assertEquals(BOKNING_TELEFON, bokning.getTelefon());
        assertEquals(BOKNING_EPOST, bokning.getEpost());
    }
}