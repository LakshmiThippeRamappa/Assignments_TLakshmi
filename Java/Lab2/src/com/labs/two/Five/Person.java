package com.labs.two.Five;


public class Person {
 private String firstName;
 private String lastName;
 private Gender gender;
 private String phoneNumber;

 // Default constructor
 public Person() {
    
 }

 // Parameterized constructor
 public Person(String firstName, String lastName, Gender gender, String phoneNumber) {
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

 public Gender getGender() {
     return gender;
 }
 public void setGender(Gender gender) {
     this.gender = gender;
 }

 public String getPhoneNumber() {
     return phoneNumber;
 }
 public void setPhoneNumber(String phoneNumber) {
     this.phoneNumber = phoneNumber;
 }


 public void displayDetails() {
     System.out.println("Person Details:\n");
     System.out.println("First Name: " + firstName);
     System.out.println("Last Name: " + lastName);
     System.out.println("Gender: " + gender);
     System.out.println("Phone Number: " + phoneNumber);
 }
}
