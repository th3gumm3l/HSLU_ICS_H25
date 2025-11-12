package ch.hslu.oop.sw09.aufgabe1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        String input;
        Logger logger = LoggerFactory.getLogger(Main.class);
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println("Bitte Temperatur eingeben (oder 'exit' zum Beenden): ");
            input = scanner.next();
            if (isNumeric(input) && !input.equals("exit")) {
                System.out.println(input);
                logger.info(input);
            }
            else {
                System.out.println("Keine gültige Nummer");
                logger.info("Keine gültige Nummer");
            }
        } while (!"exit".equals(input));
        System.out.println("Programm beendet.");
        logger.info("Programm beendet.");
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
