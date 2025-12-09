package ch.hslu.oop.sw10.aufgabe1rep;

public class Light implements Switchable {
    private int lumen = 0;
    private boolean switchedOn = false;

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
}
