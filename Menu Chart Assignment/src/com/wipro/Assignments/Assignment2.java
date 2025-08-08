package com.wipro.Assignments;
import java.util.Scanner;

/*
 2.Assignment: Java String Operations

Objective:
To implement various string operations using Java’s String class, understand string immutability, use built-in methods, and demonstrate OOP with a StringUtility class.

Requirements:
1.Create a Java program that performs the following operations on a string entered by the user:

2.Count number of vowels and consonants

3.Check if the string is a palindrome

4.Reverse the string

5.Convert the string to uppercase and lowercase

6.Replace a word in the string

7.Exit

Structure:
Class: StringUtility

Methods:

int countVowels(String str)

int countConsonants(String str)

boolean isPalindrome(String str)

String reverseString(String str)

String toUpperCase(String str)

String toLowerCase(String str)

String replaceWord(String str, String oldWord, String newWord)

Class: StringAssignmentApp

Contains main() method

Menu-driven program using switch-case and do-while
 */


public class Assignment2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StringUtility util = new StringUtility();
        char again;

        do {
            System.out.println("\n********** STRING MENU **********");
            System.out.println("1. Count Vowels and Consonants");
            System.out.println("2. Check Palindrome");
            System.out.println("3. Reverse String");
            System.out.println("4. Convert to UPPERCASE");
            System.out.println("5. Convert to lowercase");
            System.out.println("6. Replace a word");
            System.out.println("7. Exit");
            System.out.println("**********************************");
            System.out.print("Enter your choice: ");
            int choice = input.nextInt();
            input.nextLine(); // for new Line i am taking 

            switch (choice) {
                case 1:
                    System.out.print("Enter a string: ");
                    String str1 = input.nextLine();
                    int vowels = util.countVowels(str1);
                    int consonants = util.countConsonants(str1);
                    System.out.println("Vowels: " + vowels);
                    System.out.println("Consonants: " + consonants);
                    break;

                case 2:
                    System.out.print("Enter a string: ");
                    String str2 = input.nextLine();
                    if (util.isPalindrome(str2)) {
                        System.out.println("It's a palindrome.");
                    } else {
                        System.out.println("Not a palindrome.");
                    }
                    break;

                case 3:
                    System.out.print("Enter a string: ");
                    String str3 = input.nextLine();
                    System.out.println("Reversed: " + util.reverseString(str3));
                    break;

                case 4:
                    System.out.print("Enter a string: ");
                    String str4 = input.nextLine();
                    System.out.println("UPPERCASE: " + util.toUpperCase(str4));
                    break;

                case 5:
                    System.out.print("Enter a string: ");
                    String str5 = input.nextLine();
                    System.out.println("lowercase: " + util.toLowerCase(str5));
                    break;

                case 6:
                    System.out.print("Enter the full string: ");
                    String str6 = input.nextLine();
                    System.out.print("Enter word to replace: ");
                    String oldWord = input.nextLine();
                    System.out.print("Enter new word: ");
                    String newWord = input.nextLine();
                    String replaced = util.replaceWord(str6, oldWord, newWord);
                    System.out.println("Result: " + replaced);
                    break;

                case 7:
                    System.out.println("Exiting the program.");
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }

            System.out.print("\nBack to Menu? (Y/N): ");
            again = input.next().charAt(0);
        } while (again == 'Y' || again == 'y');

        System.out.println("Happy Day!!!");
    }
}

/*	OUTPUT-1

********** STRING MENU **********
1. Count Vowels and Consonants
2. Check Palindrome
3. Reverse String
4. Convert to UPPERCASE
5. Convert to lowercase
6. Replace a word
7. Exit
**********************************
Enter your choice: 1
Enter a string: hello
Vowels: 2
Consonants: 3

Back to Menu? (Y/N): n
Happy Day!!!

*/



/*	OUTPUT-2

********** STRING MENU **********
1. Count Vowels and Consonants
2. Check Palindrome
3. Reverse String
4. Convert to UPPERCASE
5. Convert to lowercase
6. Replace a word
7. Exit
**********************************
Enter your choice: 2
Enter a string: madam
It's a palindrome.

Back to Menu? (Y/N): y

********** STRING MENU **********
1. Count Vowels and Consonants
2. Check Palindrome
3. Reverse String
4. Convert to UPPERCASE
5. Convert to lowercase
6. Replace a word
7. Exit
**********************************
Enter your choice: 2
Enter a string: lakshmi
Not a palindrome.

Back to Menu? (Y/N): y

********** STRING MENU **********
1. Count Vowels and Consonants
2. Check Palindrome
3. Reverse String
4. Convert to UPPERCASE
5. Convert to lowercase
6. Replace a word
7. Exit
**********************************
Enter your choice: 3
Enter a string: hello
Reversed: olleh

Back to Menu? (Y/N): y

********** STRING MENU **********
1. Count Vowels and Consonants
2. Check Palindrome
3. Reverse String
4. Convert to UPPERCASE
5. Convert to lowercase
6. Replace a word
7. Exit
**********************************
Enter your choice: 4
Enter a string: wipro
UPPERCASE: WIPRO

Back to Menu? (Y/N): y

********** STRING MENU **********
1. Count Vowels and Consonants
2. Check Palindrome
3. Reverse String
4. Convert to UPPERCASE
5. Convert to lowercase
6. Replace a word
7. Exit
**********************************
Enter your choice: 5
Enter a string: My Name is Lakshmi
lowercase: my name is lakshmi

Back to Menu? (Y/N): y

********** STRING MENU **********
1. Count Vowels and Consonants
2. Check Palindrome
3. Reverse String
4. Convert to UPPERCASE
5. Convert to lowercase
6. Replace a word
7. Exit
**********************************
Enter your choice: 6
Enter the full string: Hello World
Enter word to replace: World
Enter new word: Team Wipro
Result: Hello Team Wipro

Back to Menu? (Y/N): 7
Happy Day!!!
*/