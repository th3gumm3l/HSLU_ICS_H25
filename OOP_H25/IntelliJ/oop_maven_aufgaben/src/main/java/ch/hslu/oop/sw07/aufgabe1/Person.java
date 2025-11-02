package ch.hslu.oop.sw07.aufgabe1;

import java.util.Objects;

public final class Person {
    private final long ID;
    private final String lastName;
    private final String firstName;

    public Person(long ID, String lastName, String firstName) {
        this.ID = ID;
        this.lastName = lastName;
        this.firstName = firstName;
    }

    public long getID() {
        return ID;
    }
    public String getLastName() {
        return lastName;
    }
    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "ID=" + ID +
                ", lastName='" + lastName + '\'' +
                ", firstName='" + firstName + '\'' +
                '}';
    }

//    @Override
//    public boolean equals(Object o) {
//        if (this == o) {
//            return true;
//        }
//        if (o == null || getClass() != o.getClass()) {
//            return false;
//        }
//        Person person = (Person) o;
//        return ID == person.ID &&
//                Objects.equals(lastName, person.lastName) &&
//                Objects.equals(firstName, person.firstName);
//    }

    @Override
    public boolean equals(final Object object) {
        if (object == this) {
            return true;
        }
        if (!(object instanceof Person person)) {
            return false;
        }
        return (person.ID == this.ID)
                && Objects.equals(person.firstName, this.firstName)
                && Objects.equals(person.lastName, this.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(ID, lastName, firstName);
    }

}
