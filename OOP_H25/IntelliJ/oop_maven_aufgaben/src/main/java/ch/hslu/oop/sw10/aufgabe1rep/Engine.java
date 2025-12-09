package ch.hslu.oop.sw10.aufgabe1rep;

public class Engine implements Switchable {
    private int rpm;
    private MotorState state;

    public Engine() {
        this.state = MotorState.OFF;
        this.rpm = 0;
    }

    @Override
    public void switchOn() {
        MotorState oldState = this.state;
        this.state = MotorState.ON;
        setRPM(1200);
    }

    @Override
    public void switchOff() {
        MotorState oldState = this.state;
        this.state = MotorState.OFF;
        setRPM(0);
    }

    @Override
    public boolean isSwitchedOn() {
        return this.state == MotorState.ON;
    }

    @Override
    public boolean isSwitchedOff() {
        return this.state == MotorState.OFF;
    }

    public int getRPM() {
        return rpm;
    }

    public void setRPM(int rpm) {
        this.rpm = rpm;
    }
}
