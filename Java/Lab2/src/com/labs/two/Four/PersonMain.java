package com.labs.two.Four;

/*
2.4: Modify Lab assignment 2.3 to accept phone number of a person. Create a newmethod to
implement the same and also define method for displaying person details.
*/

public class PersonMain {
 public static void main(String[] args) {
     
     Person person = new Person("T", "Lakshmi", 'F', "");
     person.setPhoneNumber("9398002303");
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