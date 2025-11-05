package ch.hslu.oop.sw08.aufgabe3;

public enum Aggregatzustaende {
    SOLID("Fest"),
    LIQUID("Flüssig"),
    GAS("Gasförmig");

    private final String bezeichnung;

    Aggregatzustaende(String bezeichnung) {
        this.bezeichnung = bezeichnung;
    }

    public String getBezeichnung() {
        return bezeichnung;
    }
}
