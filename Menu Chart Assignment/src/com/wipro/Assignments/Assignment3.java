package com.wipro.Assignments;

import java.util.Scanner;


/*	QUESTION:
 3. Assignment: Java OOP-Based Menu-Driven Math App

Objective:
To apply OOP concepts — Classes, Objects, Encapsulation, Abstraction, and Methods — along with looping and switch-case, by developing a real-world math utility.

Requirements:
Create a class MathOperations with:

Method: printTable(int number)

Method: calculateFactorial(int number)

Method: checkPrime(int number)

Method: printFibonacci(int terms)

Create a class MenuApp with main() method to handle:

Menu display

User input

Calling appropriate method based on user’s choice

Use OOP principles, looping, and switch-case.

Key Concepts Covered:
Encapsulation: Keeping logic in separate methods inside a class

Abstraction: Hiding internal logic, exposing only method interfaces

Class & Object: MathOperations class, called by MenuApp

Looping: For loop, while loop

Switch-case: Menu choice handling
 */

public class Assignment3 {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
     MathOperations math = new MathOperations(); // Creating object (Class & Object)
     int choice;

     do {
         // Displaying menu
         System.out.println("\n=== Math Operations Menu ===");
         System.out.println("1. Print Multiplication Table");
         System.out.println("2. Calculate Factorial");
         System.out.println("3. Check Prime Number");
         System.out.println("4. Print Fibonacci Series");
         System.out.println("5. Exit");
         System.out.print("Enter your choice: ");
         choice = scanner.nextInt();

         switch (choice) {
             case 1:
                 System.out.print("Enter a number: ");
                 int tableNum = scanner.nextInt();
                 math.printTable(tableNum);
                 break;
             case 2:
                 System.out.print("Enter a number: ");
                 int factNum = scanner.nextInt();
                 math.calculateFactorial(factNum);
                 break;
             case 3:
                 System.out.print("Enter a number: ");
                 int primeNum = scanner.nextInt();
                 math.checkPrime(primeNum);
                 break;
             case 4:
                 System.out.print("Enter number of terms: ");
                 int terms = scanner.nextInt();
                 math.printFibonacci(terms);
                 break;
             case 5:
                 System.out.println("Exiting program!");
                 break;
             default:
                 System.out.println("Invalid choice. Please try again.");
         }

     } while (choice != 5);
 }
}

/*
=== Math Operations Menu ===
1. Print Multiplication Table
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
Enter your choice: 1
Enter a number: 3
Multiplication Table for 3:
3 x 1 = 3
3 x 2 = 6
3 x 3 = 9
3 x 4 = 12
3 x 5 = 15
3 x 6 = 18
3 x 7 = 21
3 x 8 = 24
3 x 9 = 27
3 x 10 = 30

=== Math Operations Menu ===
1. Print Multiplication Table
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
Enter your choice: 2
Enter a number: 5
Factorial of 5 is: 120

=== Math Operations Menu ===
1. Print Multiplication Table
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
Enter your choice: 3
Enter a number: 3
3 is a prime number.

=== Math Operations Menu ===
1. Print Multiplication Table
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
Enter your choice: 4
Enter number of terms: 7
Fibonacci series :
0 1 1 2 3 5 8

=== Math Operations Menu ===
1. Print Multiplication Table
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
Enter your choice: 5
Exiting program!

*/