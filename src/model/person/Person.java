package model.person;


import model.common.Fireable;
import model.common.Persistable;
import model.unit.Faculty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public abstract class Person extends Persistable implements Fireable {

    String firstName;
    String lastName;
    LocalDate birthDay;

    // Constructor 1
   public Person(String inFirstName, String inLastName, LocalDate inBirthDate) {
        checkFirstName(inFirstName);
        checkLastName(inLastName);
        checkBirthDate(inBirthDate);
        this.firstName = inFirstName;
        this.lastName = inLastName;
        this.birthDay = inBirthDate;
    }

    // Constructor2
    public Person(String inFirstName, String inLastName, String inBirthDate_yyyymmdd) {
        checkFirstName(inFirstName);
        checkLastName(inLastName);
        this.birthDay = LocalDate.parse(inBirthDate_yyyymmdd, DateTimeFormatter.ofPattern("yyyyMMdd"));
        checkBirthDate(birthDay);
        this.firstName = inFirstName;
        this.lastName = inLastName;
    }

    private void checkFirstName(String firstName) {
        if (firstName.length() < 1 ) {
            throw new IllegalArgumentException("Incorrect FirstName.");
        }

    }
    private void checkLastName(String lastName) {
        if (lastName.length() < 1 ) {
            throw new IllegalArgumentException("Incorrect LastName.");
        }

    }

    private void checkBirthDate(LocalDate birthDay) {
        LocalDate now = LocalDate.now();
        if (now.getYear() - birthDay.getYear() <= 10) {
            throw new IllegalArgumentException("Birthday must be not less than 10 years ago");
        }

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        checkFirstName(firstName);
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        checkLastName(lastName);
        this.lastName = lastName;
    }

    public LocalDate getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(LocalDate birthDay) {
        checkBirthDate(birthDay);
        this.birthDay = birthDay;
    }
    public void setBirthDay(String instringDate_yyyymmdd) {
        this.birthDay = LocalDate.parse(instringDate_yyyymmdd, DateTimeFormatter.ofPattern("yyyyMMdd"));
        checkBirthDate(birthDay);
    }
    public abstract void fire();
    public abstract Faculty getFaculty();

    @Override
    public String toString() {
     return "ID: " + getId() + "; " + this.getClass().getSimpleName() + " " + firstName + " " + lastName + "; Birthday: " + birthDay.format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
