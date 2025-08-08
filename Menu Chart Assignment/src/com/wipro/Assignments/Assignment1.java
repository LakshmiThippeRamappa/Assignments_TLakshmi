package com.wipro.Assignments;
import java.util.Scanner;
/*
 1.Assignment: Java Looping and Switch

Objective:
To implement basic looping (for, while, do-while) and switch-case constructs in Java through real-life problem-solving.

 Problem Statement: Menu-Driven Math Operations

Create a Java program that repeatedly shows a menu with options to perform simple mathematical operations using a switch-case. The program should use loops to keep the menu running until the user chooses to exit.

********** MENU **********
1. Print Table of a Number
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
**************************
Enter your choice: 

Requirements:
Use a switch-case to handle menu choices.

Use looping constructs (for, while, or do-while) appropriately:

for for multiplication table and factorial

while for checking prime

do-while for keeping the menu running until Exit

Use Scanner for input.

********** MENU **********
1. Print Table of a Number
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
**************************
Enter your choice: 1
Enter the number: 5
5 x 1 = 5
5 x 2 = 10
...
5 x 10 = 50

Back to Menu? (Y/N): Y

 */

public class Assignment1{
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        char again;

        do {
            // Displaying the menu
            System.out.println("\n********** MENU **********");
            System.out.println("1. Print Table of a Number");
            System.out.println("2. Calculate Factorial");
            System.out.println("3. Check Prime Number");
            System.out.println("4. Print Fibonacci Series");
            System.out.println("5. Exit");
            System.out.println("**************************");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    // Printing multiplication table
                    System.out.print("Enter a number: ");
                    int n = input.nextInt();
                    for (int i = 1; i <= 10; i++) {
                        System.out.println(n + " x " + i + " = " + (n * i));
                    }
                    break;

                case 2:
                    // Calculating factorial
                    System.out.print("Enter a number: ");
                    int num = input.nextInt();
                    int fact = 1;
                    for (int i = 1; i <= num; i++) {
                        fact = fact * i;
                    }
                    System.out.println("Factorial of " + num + " is " + fact);
                    break;

                case 3:
                    // Checking if number is prime or not.
                    System.out.print("Enter a number: ");
                    int number = input.nextInt();
                    boolean isPrime = true;
                    if (number <= 1) {
                        isPrime = false;
                    } else {
                        int i = 2;
                        while (i <= number / 2) {
                            if (number % i == 0) {
                                isPrime = false;
                                break;
                            }
                            i++;
                        }
                    }
                    if (isPrime) {
                        System.out.println(number + " is a Prime Number.");
                    } else {
                        System.out.println(number + " is NOTa Prime Number.");
                    }
                    break;

                case 4:
                    // Printing Fibonaci series
                    System.out.print("Enter how many terms: ");
                    int terms = input.nextInt();
                    int a = 0, b = 1;
                    System.out.print("Fibonacci Series: ");
                    for (int i = 1; i <= terms; i++) {
                        System.out.print(a + " ");
                        int next = a + b;
                        a = b;
                        b = next;
                    }
                    System.out.println();
                    break;

                case 5:
                    // Exit
                    System.out.println("Exiting the program.");
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }

            //if we wnat to continue 
            System.out.print("Back to Menu? (Y/N): ");
            again = input.next().charAt(0);

        } while (again == 'Y' || again == 'y');
        System.out.println("Happy Day!");
    }
}

/*


********** MENU **********
1. Print Table of a Number
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
**************************
Enter your choice: 1
Enter a number: 5
5 x 1 = 5
5 x 2 = 10
5 x 3 = 15
5 x 4 = 20
5 x 5 = 25
5 x 6 = 30
5 x 7 = 35
5 x 8 = 40
5 x 9 = 45
5 x 10 = 50
Back to Menu? (Y/N): y

********** MENU **********
1. Print Table of a Number
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
**************************
Enter your choice: 2
Enter a number: 6
Factorial of 6 is 720
Back to Menu? (Y/N): y

********** MENU **********
1. Print Table of a Number
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
**************************
Enter your choice: 3
Enter a number: 9
9 is NOTa Prime Number.
Back to Menu? (Y/N): y

********** MENU **********
1. Print Table of a Number
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
**************************
Enter your choice: 4
Enter how many terms: 11
Fibonacci Series: 0 1 1 2 3 5 8 13 21 34 55 
Back to Menu? (Y/N): y

********** MENU **********
1. Print Table of a Number
2. Calculate Factorial
3. Check Prime Number
4. Print Fibonacci Series
5. Exit
**************************
Enter your choice: 5
Exiting the program.

*/