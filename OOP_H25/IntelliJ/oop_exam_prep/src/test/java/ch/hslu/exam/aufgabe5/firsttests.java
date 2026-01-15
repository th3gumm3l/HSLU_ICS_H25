package ch.hslu.exam.aufgabe5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class firsttests {

    @Test
    void shouldSetParameterCorrectly() {
        //Given & When
        Raum raum = new Raum(200,100);

        //Then
        assertEquals(100, raum.getKapazitaet());
        assertEquals(200, raum.getRaumNummer());
    }

    @Test
    void shouldHandleTooLowRaumNummerCorrectly() {
        //When Then
        assertThrows(IllegalArgumentException.class, () -> new Raum(99,100));
    }

    @Test
    void shouldHandleTooHighRaumNummerCorrectly() {
        //When Then
        assertThrows(IllegalArgumentException.class, () -> new Raum(1001,100));
    }

    @Test
    void shouldHandleTooLowCapacityCorrectly() {
        assertThrows(IllegalArgumentException.class, () -> new Raum(111,1));
    }

    @Test
    void shouldHandleEqualRoomNummerCorrectly() {
        Raum raum = new Raum(222,100);
        Raum raum2 = new Raum(222,300);
        assertEquals(raum2, raum);
    }

}
