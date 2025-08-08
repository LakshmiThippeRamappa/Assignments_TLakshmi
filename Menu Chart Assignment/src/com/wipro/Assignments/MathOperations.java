package com.wipro.Assignments;
//This class is to handlesall math operations -Encapsulation.
public class MathOperations {

 // Printing multiplication t
 public void printTable(int number) {
     System.out.println("Multiplication Table for " + number + ":");
     for (int i = 1; i <= 10; i++) {
         System.out.println(number + " x " + i + " = " + (number * i));
     }
 }

 // Calculating factorial of a number
 public void calculateFactorial(int number) {
     if (number < 0) {
         System.out.println("Factorial is not applicable for -ve numbers ");
         return;
     }
     int fact = 1;
     for (int i = 2; i <= number; i++) {
         fact *= i;
     }
     System.out.println("Factorial of " + number + " is: " + fact);
 }

 // Checking if a number is prime or not
 public void checkPrime(int number) {
     if (number <= 1) {
         System.out.println(number + " is not a prime number.");
         return;
     }
     boolean isPrime = true;
     for (int i = 2; i <= Math.sqrt(number); i++) {
         if (number % i == 0) {
             isPrime = false;
             break;
         }
     }
     System.out.println(number + (isPrime ? " is a prime number." : " is not a prime number."));
 }

 // Printing Fibonaccci series up to given number of terms
 public void printFibonacci(int terms) {
     if (terms <= 0) {
         System.out.println("Please enter a positive number of terms.");
         return;
     }

     System.out.println("Fibonacci series :");
     int a = 0, b = 1;
     System.out.print(a);
     for (int i = 1; i < terms; i++) {
         System.out.print(" " + b);
         int next = a + b;
         a = b;
         b = next;
     }
     System.out.println();
 }
}
