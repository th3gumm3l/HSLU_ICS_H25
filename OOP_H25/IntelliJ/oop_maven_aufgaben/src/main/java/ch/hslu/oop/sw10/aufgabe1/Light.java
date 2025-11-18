package ch.hslu.oop.sw10.aufgabe1;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.List;

public class Light implements Switchable {
    private int lumen = 0;
    private boolean switchedOn = false;
    private List<PropertyChangeListener> listeners;

    @Override
    public void switchOn() {
        this.switchedOn = true;
        this.lumen = 8000;
    }

    @Override
    public void switchOff() {
        this.switchedOn = false;
        this.lumen = 0;
    }

    @Override
    public boolean isSwitchedOn() {
        return this.switchedOn;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.switchedOn;
    }

    public void addPropertyChangeListener(PropertyChangeListener listener) {
        listeners.add(listener);
    }

    public void removePropertyChangeListener(PropertyChangeListener listener) {
        listeners.remove(listener);
    }

    protected void firePropertyChangeEvent(PropertyChangeEvent pcEvent) {
        for (PropertyChangeListener listener : listeners) {
            listener.propertyChange(pcEvent);
        }
    }
}
