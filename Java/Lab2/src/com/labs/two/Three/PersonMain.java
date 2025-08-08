package com.labs.two.Three;
/*
 2.3: Refer the class diagram given below and createa personclass.
Figure 13: Class Diagram of Person---

Create default and parameterized constructor for Person class.
Also Create “PersonMain.java” program and write code for following operations:
a) Create an object of Person class and specify person details through constructor.
b) Display the details in the format given in Lab assignment 2.1
 */

public class PersonMain {
 public static void main(String[] args) {
 
     Person person = new Person("T ", "Lakshmi", 'F');

     
     System.out.println("Person Details:\n");
     System.out.println("First Name: " + person.getFirstName());
     System.out.println("Last Name: " + person.getLastName());
     System.out.println("Gender: " + person.getGender());
 }
}
/*
Person Details:

First Name: T 
Last Name: Lakshmi
Gender: F
*/