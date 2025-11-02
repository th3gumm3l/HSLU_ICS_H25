package ch.hslu.oop.sw07.aufgabe2;

import java.util.Comparator;

public class PersonComparatorByName implements Comparator<Person> {
    @Override
    public int compare(Person p1, Person p2) {
        int cmp = p1.getLastName().compareToIgnoreCase(p2.getLastName());

        if (cmp != 0){
            return cmp;
        }

        return p1.getFirstName().compareToIgnoreCase(p2.getFirstName());
    }
}

