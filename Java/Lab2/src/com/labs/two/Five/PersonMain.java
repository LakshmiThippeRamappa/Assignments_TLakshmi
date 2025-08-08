package com.labs.two.Five;

/*
 2.5: Modify the above program, to accept only ‘M’ or ‘F’ as gender field values. Use Enumeration
for implementing the same.
 */

public class PersonMain {
 public static void main(String[] args) {

     Person person = new Person("T", "Lakshmi", Gender.F, "9398002303");

     person.displayDetails();
 }
}


/*
Person Details:

First Name: T
Last Name: Lakshmi
Gender: F
Phone Number: 9398002303
*/