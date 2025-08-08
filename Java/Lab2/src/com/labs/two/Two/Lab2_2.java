package com.labs.two.Two;
/*
 2.2: Write a program to accept a number from user as a command line argument and check
whether the given number is positive or negative number.
 */
public class Lab2_2 {
	public static void main(String[] args) {
		int num = Integer.parseInt(args[0]);
		if (num > 0) {
            System.out.println("The number is positive.");
        } else if (num < 0) {
            System.out.println("The number is negative.");
        } else {
            System.out.println("The number is zero.");
        }
    }
}
