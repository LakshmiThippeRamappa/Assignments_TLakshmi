package com.labs.Three.seven;
/*
3.7 : Modify Lab assignment 2.3 to perform following functionalities:
a) Add a method called calculateAge which should accept person’s date of birth and
calculate age of a person.
b) Add a method called getFullName(String firstName, String lastName) which should
return full name of a person

Display person details with age and fullname.
 */
import java.time.LocalDate;
import java.util.Scanner;

public class PersonMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter First Name: ");
        String firstName = sc.nextLine();

        System.out.print("Enter Last Name: ");
        String lastName = sc.nextLine();

        System.out.print("Enter Gender (M/F): ");
        char gender = sc.next().charAt(0);

        System.out.print("Enter Date of Birth (yyyy-mm-dd): ");
        String dobInput = sc.next();
        LocalDate dob = LocalDate.parse(dobInput);

        Person person = new Person(firstName, lastName, gender, dob);

        // Displaying details
        person.displayDetails();
    }
}
/*
Enter First Name: Divya
Enter Last Name: Bharathi
Enter Gender (M/F): F
Enter Date of Birth (yyyy-mm-dd): 2005-07-15

Person Details:
Full Name: Divya Bharathi
Gender: F
Date of Birth: 2005-07-15
Age: 20

*/