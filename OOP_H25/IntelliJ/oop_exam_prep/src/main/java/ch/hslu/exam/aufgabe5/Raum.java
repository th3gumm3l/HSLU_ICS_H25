package ch.hslu.exam.aufgabe5;

import ch.hslu.exam.aufgabe2.RaumStatus;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public final class Raum implements Comparable<Raum> {
    private final int raumNummer;
    private final int kapazitaet;
    private RaumStatus status;

    Raum(int raumNummer, int kapazitaet) {
        if (raumNummer < 100 || raumNummer > 999) {
            throw new IllegalArgumentException("Die Raumnummer ist ausserhalb des Bereichs (100-999)");
        }
        if (kapazitaet <= 2) {
            throw new IllegalArgumentException("Die Kapazität ist zu klein");
        }
        this.raumNummer = raumNummer;
        this.kapazitaet = kapazitaet;
        this.status = RaumStatus.FREI;
    }

    public int getRaumNummer() {
        return raumNummer;
    }
    public int getKapazitaet() {
        return kapazitaet;
    }

    public RaumStatus getStatus() { return status; }
    void setStatus(RaumStatus status) { this.status = status; }

    public boolean isFrei() {
        if (status == RaumStatus.FREI) {
            return true;
        }
        return false;
    }

    /* Event-Handling */
    private final List<PropertyChangeListener> changeListeners = new ArrayList<>();

    public void addPropertyChangeListener(final PropertyChangeListener listener) {
        this.changeListeners.add(listener);
    }

    public void removePropertyChangeListener(final PropertyChangeListener listener) {
        this.changeListeners.remove(listener);
    }

    private void firePropertyChangeEvent(final PropertyChangeEvent pcEvent) {
        for (final PropertyChangeListener listener : this.changeListeners) {
            listener.propertyChange(pcEvent);
        }
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

    @Override
    public int compareTo(final Raum other) {
        return Integer.compare(this.raumNummer, other.raumNummer);
    }

    @Override
    public String toString() {
        return "Raum{" +
                "raumNummer=" + raumNummer +
                ", kapazitaet=" + kapazitaet +
                ", status=" + status +
                '}';
    }
}
