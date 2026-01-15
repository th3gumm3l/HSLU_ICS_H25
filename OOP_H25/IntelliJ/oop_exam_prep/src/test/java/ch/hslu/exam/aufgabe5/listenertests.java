package ch.hslu.exam.aufgabe5;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class listenertests {

    @Test
    void shouldFireEventWhenReserve() {
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        List<RaumEvent> raumEvents = new ArrayList<>();
        raumVerwaltung.addRaumEventListener(raumEvents::add);

        raumVerwaltung.reservieren(new Raum(100,11), 2);

        assertEquals(1, raumEvents.size());
    }

    @Test
    void shouldFireEventWithCorrectContentWhenReserving() {
        // Arrange
        RaumVerwaltung raumVerwaltung = new RaumVerwaltung();
        List<RaumEvent> events = new ArrayList<>();
        raumVerwaltung.addRaumEventListener(events::add);

        // Act: reserviere einen Raum für 11 Personen
        Raum reservierterRaum = raumVerwaltung.getRichtigerRaum(11);

        // Assert: Event wurde ausgelöst
        assertEquals(1, events.size());

        // Event-Inhalt prüfen
        RaumEvent event = events.get(0);
        assertEquals("Raum reserviert", event.getAction());
        assertEquals(reservierterRaum, event.getRaum());
        assertEquals(11, event.getAnzahlPleatze()); // sollte die angeforderte Personenzahl sein
    }


}
