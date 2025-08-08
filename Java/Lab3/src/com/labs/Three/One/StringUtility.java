package com.labs.Three.One;

public class StringUtility {

 public static String processString(String input, int choice) {
     switch (choice) {
         case 1:
             // Add the string to itself
             return input + input;

         case 2:
             // Replace characters at odd positions (1-based index) with '#'
             StringBuilder sb2 = new StringBuilder(input);
             for (int i = 0; i < sb2.length(); i++) {
                 if ((i + 1) % 2 != 0) { // odd positions
                     sb2.setCharAt(i, '#');
                 }
             }
             return sb2.toString();

         case 3:
             // Remove duplicate characters
             StringBuilder sb3 = new StringBuilder();
             for (int i = 0; i < input.length(); i++) {
                 char ch = input.charAt(i);
                 if (sb3.indexOf(String.valueOf(ch)) == -1) {
                     sb3.append(ch);
                 }
             }
             return sb3.toString();

         case 4:
             // Change characters at odd positions to uppercase
             StringBuilder sb4 = new StringBuilder();
             for (int i = 0; i < input.length(); i++) {
                 char ch = input.charAt(i);
                 if ((i + 1) % 2 != 0) { // odd positions
                     sb4.append(Character.toUpperCase(ch));
                 } else {
                     sb4.append(ch);
                 }
             }
             return sb4.toString();

         default:
             return "Invalid choice.";
     }
 }
}