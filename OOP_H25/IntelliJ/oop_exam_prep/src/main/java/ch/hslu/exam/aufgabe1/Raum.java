package ch.hslu.exam.aufgabe1;

import java.util.Objects;

public final class Raum {
    private final int raumNummer;
    private final int kapazitaet;

    Raum(int raumNummer, int kapazitaet) {
        if (raumNummer < 100 || raumNummer > 999) {
            throw new IllegalArgumentException("Die Raumnummer ist ausserhalb des Bereichs (100-999)");
        }
        if (kapazitaet <= 2) {
            throw new IllegalArgumentException("Die Kapazität ist zu klein");
        }
        this.raumNummer = raumNummer;
        this.kapazitaet = kapazitaet;
    }

    public int getRaumNummer() {
        return raumNummer;
    }
    public int getKapazitaet() {
        return kapazitaet;
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Raum raum)) return false;
        return getRaumNummer() == raum.getRaumNummer();
    }

    @Override
    public int hashCode() {
        return Objects.hash(this.raumNummer);
    }
}
