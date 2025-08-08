package com.labs.Three.seven;
import java.time.LocalDate;
import java.time.Period;

public class Person {
    private String firstName;
    private String lastName;
    private char gender;
    private LocalDate dateOfBirth;

    // Default constructor
    public Person() {}

    // Parameterized constructor
    public Person(String firstName, String lastName, char gender, LocalDate dateOfBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.dateOfBirth = dateOfBirth;
    }

    // Getters and setters
    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public char getGender() {
        return gender;
    }

    public void setGender(char gender) {
        this.gender = gender;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    // Method to calculate age
    public int calculateAge() {
        return Period.between(dateOfBirth, LocalDate.now()).getYears();
    }

    // Method to get full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Method to display person details
    public void displayDetails() {
        System.out.println("Person Details:");
        System.out.println("Full Name: " + getFullName());
        System.out.println("Gender: " + gender);
        System.out.println("Date of Birth: " + dateOfBirth);
        System.out.println("Age: " + calculateAge());
    }
}
