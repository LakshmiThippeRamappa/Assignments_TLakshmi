package com.labs.two.Four;

public class Person {
 // Fields
 private String firstName;
 private String lastName;
 private char gender;
 private String phoneNumber;

 // Default constructor
 public Person() {
     
 }

 // Parameterized constructor
 public Person(String firstName, String lastName, char gender, String phoneNumber) {
     this.firstName = firstName;
     this.lastName = lastName;
     this.gender = gender;
     this.phoneNumber = phoneNumber;
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

 public String getPhoneNumber() {
     return phoneNumber;
 }

 // Method to accept phone number
 public void setPhoneNumber(String phoneNumber) {
     this.phoneNumber = phoneNumber;
 }

 // Method to display all details
 public void displayDetails() {
     System.out.println("Person Details:\n");
     System.out.println("First Name: " + firstName);
     System.out.println("Last Name: " + lastName);
     System.out.println("Gender: " + gender);
     System.out.println("Phone Number: " + phoneNumber);
 }
}
