package se.hakanostrom.stugan.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class StugaTest {

    private final Long STUGA_ID = 1L;
    private final String STUGA_NAMN = "Merlo";

    Stuga stuga;

    @BeforeEach
    void setUp() {
        stuga = new Stuga()
                .setID(STUGA_ID)
                .setName(STUGA_NAMN);
    }

    @Test
    void testGetterSetter() {
        assertEquals(STUGA_ID, stuga.getID());
        assertEquals(STUGA_NAMN, stuga.getName());
    }

}