package ch.hslu.oop.sw07.aufgabe1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import nl.jqno.equalsverifier.*;

class PersonTest {

    @Test
    void testKonstruktor() {
        Person p = new Person(1L, "Müller", "Anna");
        assertEquals(1L, p.getID());
        assertEquals("Müller", p.getLastName());
        assertEquals("Anna", p.getFirstName());
    }

    @Test
    void testEqualsTrueUndFalse() {
        Person p1 = new Person(1L, "Meier", "Hans");
        Person p2 = new Person(1L, "Meier", "Hans");
        Person p3 = new Person(2L, "Müller", "Anna");

        // Achtung: Wenn equals() noch nicht überschrieben ist, ist das Ergebnis:
        // p1.equals(p2) => false (weil verschiedene Objekte, trotz gleicher Daten)
        // p1.equals(p1) => true (weil dieselbe Referenz)
        // Nach der Implementierung von equals() (in Aufgabe 1g) wird p1.equals(p2) true liefern.

        System.out.println("p1 == p2: " + (p1 == p2));          // false
        System.out.println("p1.equals(p2): " + p1.equals(p2));  // zunächst false, später true
        System.out.println("p1.equals(p3): " + p1.equals(p3));  // immer false

        // Erwartetes Verhalten *nach* der Implementierung:
        assertTrue(p1.equals(p2));   // gleiche ID → gleich
        assertFalse(p1.equals(p3));  // verschiedene ID → ungleich
    }

    @Test
    void testHashCodeKonsistentMitEquals() {
        Person p1 = new Person(1L, "Meier", "Hans");
        Person p2 = new Person(1L, "Meier", "Hans"); // gleiche ID → equals() == true
        Person p3 = new Person(2L, "Müller", "Anna"); // andere ID → equals() == false

        // gleich lautende Objekte müssen denselben Hashcode haben
        assertEquals(p1, p2);
        assertEquals(p1.hashCode(), p2.hashCode());

        // ungleiche Objekte sollen möglichst unterschiedlichen Hashcode haben
        assertNotEquals(p1, p3);
        // kein Muss, aber meistens erwünscht:
        assertNotEquals(p1.hashCode(), p3.hashCode());
    }

    @Test
    public void equalsContract() {
        EqualsVerifier.forClass(Person.class).verify();
    }
}