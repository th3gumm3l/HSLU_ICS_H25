package ch.hslu.exam.aufgabe5;

import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class secondtests {

    @Test
    void shouldSetStatusCorrectly() {
        //Given & When
        Raum raum = new Raum(100,100);

        //Then
        assertEquals(Status.FREI, raum.getStatus());
    }

    @Test
    void shouldSaveRaumToRaumVerwaltung() {
        //Given
        Raum raum = new Raum(100,100);
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();

        //When
        raumVerwaltung.add(raum);

        //Then
        assertTrue(raumVerwaltung.getRaumList().containsKey(raum.getRaumNummer()));
    }

    @Test
    void shouldGetRaumAusRaumVerwaltungPerRaumNummer() {
        Raum raum = new Raum(100,100);
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        raumVerwaltung.add(raum);

        Raum raumResult = raumVerwaltung.getPerNummer(raum.getRaumNummer());

        assertEquals(raum, raumResult);
    }

    @Test
    void shouldThrowNoSuchElementException() {
        Raum raum = new Raum(100,100);
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        raumVerwaltung.add(raum);

        assertThrows(NoSuchElementException.class, () -> raumVerwaltung.getPerNummer(200));

    }

}
