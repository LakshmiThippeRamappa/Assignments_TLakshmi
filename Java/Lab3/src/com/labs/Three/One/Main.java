package com.labs.Three.One;
/*
 3.1 : Create a method which can perform a particular String operation based on the user’s choice.
The method should accept the String object and the user’s choice and return the output of the
operation.
Options are
 Add the String to itself
 Replace odd positions with #
 Remove duplicate characters in the String
 Change odd characters to upper case
 */
import java.util.Scanner;

public class Main {
 public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
    char again;
    
	do {
     System.out.print("Enter a string: ");
     String input = scanner.nextLine();

     System.out.println("Choose an operation:");
     System.out.println("1. Add the string to itself");
     System.out.println("2. Replace odd positions with #");
     System.out.println("3. Remove duplicate characters");
     System.out.println("4. Change odd characters to upper case");

     System.out.print("Enter your choice (1-4): ");
     int choice = scanner.nextInt();
     scanner.nextLine(); // ✅ Consume the newline
     
     String result = StringUtility.processString(input, choice);

     
     System.out.println("Result: " + result);
     
     System.out.print("Back to Menu? (Y/N): ");
     again = scanner.nextLine().charAt(0);
     
     // Keep asking until valid input
     while (again != 'Y' && again != 'y' && again != 'N' && again != 'n') {
         System.out.print("Invalid input. Please enter Y or N: ");
         again = scanner.nextLine().charAt(0);
     }
     
    }while(again=='y' || again=='Y');
	System.out.println("Happy Day!");
 }
}

/*
Enter a string: Lakshmi
Choose an operation:
1. Add the string to itself
2. Replace odd positions with #
3. Remove duplicate characters
4. Change odd characters to upper case
Enter your choice (1-4): 1
Result: LakshmiLakshmi
Back to Menu? (Y/N): 8
Invalid input. Please enter Y or N: y
Enter a string: Hai
Choose an operation:
1. Add the string to itself
2. Replace odd positions with #
3. Remove duplicate characters
4. Change odd characters to upper case
Enter your choice (1-4): 2
Result: #a#
Back to Menu? (Y/N): m
Invalid input. Please enter Y or N: n
Happy Day!
*/
