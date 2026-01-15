package ch.hslu.exam.aufgabe5;

import nl.jqno.equalsverifier.EqualsVerifier;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

public class thirdtests {

    @Test
    void equalsContract() {
        EqualsVerifier.forClass(Raum.class)
            .withOnlyTheseFields("raumNummer")
            .verify();
    }

    @Test
    void shouldTestIstRaumFreiWennTrue(){
        Raum raum1 = new Raum(100,100);

        assertTrue(raum1.istRaumFrei());
    }

    @Test
    void shouldTestIstRaumFreiWennFalse(){
        Raum raum1 = new Raum(100,100);
        raum1.setStatus(Status.BELEGT);

        assertFalse(raum1.istRaumFrei());
    }

    @Test
    void shouldHandleGetRichtigerRaumCorrectlyWhenRaumVerfuegbar(){
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        Raum result = raumVerwaltung.getRichtigerRaum(11);

        assertEquals(result, raumVerwaltung.raumList.get(603));
        assertEquals(Status.BELEGT, result.getStatus());
    }

    @Test
    void shouldHandleGetRichtigerRaumCorrectlyWhenRaumNichtVerfuegbar() {
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();

        assertThrows(NoSuchElementException.class, () -> raumVerwaltung.getRichtigerRaum(888));
    }

    @Test
    void shouldSetRaumFree() {
        Raum raum1 = new Raum(100,100);
        raum1.setStatus(Status.BELEGT);
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        raumVerwaltung.add(raum1);

        boolean result = raumVerwaltung.raumFreigeben(raum1);

        assertTrue(result);
    }

    @Test
    void shouldSetRaumFreeWhenAlreadyFree() {
        Raum raum1 = new Raum(100,100);
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        raumVerwaltung.add(raum1);

        boolean result = raumVerwaltung.raumFreigeben(raum1);

        assertFalse(result);
    }

    @Test
    void shouldSetRaumFreeWhenRoomDoesntExist() {
        Raum raum1 = new Raum(100,100);
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        raumVerwaltung.add(raum1);
        Raum raum2 = new Raum(150,150);

        boolean result = raumVerwaltung.raumFreigeben(raum2);

        assertFalse(result);
    }


}
