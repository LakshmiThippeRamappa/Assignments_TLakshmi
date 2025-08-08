package com.labs.Three.Two;
/*
3.2 : Create a method that accepts a String and checks if it is a positive string. A string is
considered a positive string, if on moving from left to right each character in the String comes
after the previous characters in the Alphabetical order.For Example: ANT is a positive String
(Since T comes after N and N comes after A). The method should return true if the entered string
is positive.
 */

import java.util.Scanner;

public class PositiveStringChecker {

    // Method to check if a string is positive
    public static boolean isPositiveString(String input) {
        input = input.toUpperCase(); // Case-insensitive check

        for (int i = 0; i < input.length() - 1; i++) {
            if (input.charAt(i) > input.charAt(i + 1)) {
                return false; // Not in increasing alphabetical order
            }
        }
        return true;
    }

    // Main method
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char again;

        do {
            System.out.print("Enter a string: ");
            String input = scanner.nextLine();

            boolean result = isPositiveString(input);

            if (result) {
                System.out.println("The string is a POSITIVE string.");
            } else {
                System.out.println("The string is NOT a positive string.");
            }

            System.out.print("Check another? (Y/N): ");
            again = scanner.next().charAt(0);
            scanner.nextLine(); // consume leftover newline

        } while (again == 'Y' || again == 'y');

        System.out.println("Goodbye!");
        scanner.close();
    }
}
/*
Enter a string: ant
The string is a POSITIVE string.
Check another? (Y/N): y
Enter a string: laksh
The string is NOT a positive string.
Check another? (Y/N): n
Goodbye!
*/