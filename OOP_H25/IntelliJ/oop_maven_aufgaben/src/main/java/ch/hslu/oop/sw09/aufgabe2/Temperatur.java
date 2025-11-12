package ch.hslu.oop.sw09.aufgabe2;

import ch.hslu.oop.sw09.aufgabe1.Main;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

/**
 * Beschreibt die Temperatur in ihren Basiseigenschaften und Methoden
 *
 * @author Tim Bernhard
 * @version 1
 */
public final class Temperatur implements Comparable<Temperatur> {
    private float kelvin;
    private final static float KELVIN_OFFSET = 273.15f;

    private Temperatur(float kelvin) {
        if (kelvin < 0.0f) {
            throw new IllegalArgumentException("Temperaturwert darf nicht negativ sein.");
        }
        this.kelvin = roundResult(kelvin);
    }

    private Temperatur(Temperatur temperatur) {
        this.kelvin = temperatur.kelvin;
    }

    public static Temperatur createFromCelsius(final float celsius){
        return new Temperatur(convertCelsiusToKelvin(celsius));
    }

    public static Temperatur createFromKelvin(final float kelvin){
        return new Temperatur(kelvin);
    }

    public float getKelvin() {
        return kelvin;
    }

    public float getCelsius() {
        return convertKelvinToCelsius(kelvin);
    }

    @Override
    public boolean equals(Object o) {
        if (!(o instanceof Temperatur that)) return false;
        return Float.compare(getKelvin(), that.getKelvin()) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(getKelvin());
    }

    @Override
    public String toString() {
        return "Temperatur{" + "kelvin=" + kelvin + '}';
    }

    @Override
    public int compareTo(Temperatur temperatur) {
        return Float.compare(this.kelvin, temperatur.kelvin);
    }

    /*
    Hilfsfunktionen
     */
    public static float convertKelvinToCelsius(float kelvin) {
        return roundResult(kelvin - KELVIN_OFFSET);
    }

    public static float convertCelsiusToKelvin(float celsius) {
        return roundResult(celsius + KELVIN_OFFSET);
    }

    private static float roundResult(float input) {
        return Math.round(input * 100.0f) / 100.0f;
    }
}
