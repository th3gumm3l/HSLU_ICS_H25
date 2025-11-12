package ch.hslu.oop.sw09.aufgabe1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            if (isNumeric(input) && !input.equals("exit")) {
                System.out.println(input);
            }
            else {
                System.out.println("Keine gültige Nummer");
            }
        } while (!"exit".equals(input));
        System.out.println("Programm beendet.");
    }

    public static boolean isNumeric(String str) {
        try {
            Float.parseFloat(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
