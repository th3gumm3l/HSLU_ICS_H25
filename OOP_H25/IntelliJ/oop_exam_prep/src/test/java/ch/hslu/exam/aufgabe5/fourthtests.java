package ch.hslu.exam.aufgabe5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class fourthtests {

    @Test
    void shouldReserveSmallestRoom() {
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        raumVerwaltung.getRichtigerRaum(11);
        raumVerwaltung.getRichtigerRaum(17);
        raumVerwaltung.getRichtigerRaum(6);

        assertFalse(raumVerwaltung.getRaumList().get(600).istRaumFrei());
        assertFalse(raumVerwaltung.getRaumList().get(602).istRaumFrei());
        assertFalse(raumVerwaltung.getRaumList().get(603).istRaumFrei());
    }


    @Test
    void shouldSetRaumFree() {
        Raum raum1 = new Raum(100,100);
        raum1.setStatus(Status.BELEGT);
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        raumVerwaltung.add(raum1);

        boolean result = raumVerwaltung.raumFreigeben(100);

        assertTrue(result);
    }

    @Test
    void shouldSetRaumFreeWhenAlreadyFree() {
        Raum raum1 = new Raum(100,100);
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        raumVerwaltung.add(raum1);

        boolean result = raumVerwaltung.raumFreigeben(100);

        assertFalse(result);
    }

    @Test
    void shouldSetRaumFreeWhenRoomDoesntExist() {
        Raum raum1 = new Raum(100,100);
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        raumVerwaltung.add(raum1);
        Raum raum2 = new Raum(150,150);

        boolean result = raumVerwaltung.raumFreigeben(111);

        assertFalse(result);
    }

}
