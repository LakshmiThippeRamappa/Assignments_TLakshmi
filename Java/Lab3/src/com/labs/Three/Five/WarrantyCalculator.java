package com.labs.Three.Five;

/*
3.5 : Create a method to accept product purchase date and warrantee period (in terms of months
and years). Print the date on which warrantee of product expires.
 */

import java.time.LocalDate;
import java.util.Scanner;

public class WarrantyCalculator {

    // Method to calculate warranty expiry date
    public static void calculateWarrantyExpiry(LocalDate purchaseDate, int years, int months) {
        // Add warranty period to the purchase date
        LocalDate expiryDate = purchaseDate.plusYears(years).plusMonths(months);

        // Display results
        System.out.println("Purchase Date       : " + purchaseDate);
        System.out.println("Warranty Period     : " + years + " years, " + months + " months");
        System.out.println("Warranty Expiry Date: " + expiryDate);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char again;

        do {
            try {
                // Input
                System.out.print("Enter purchase date (yyyy-MM-dd): ");
                String purchaseDateStr = scanner.nextLine();
                LocalDate purchaseDate = LocalDate.parse(purchaseDateStr);

                System.out.print("Enter warranty period in years: ");
                int years = scanner.nextInt();

                System.out.print("Enter warranty period in months: ");
                int months = scanner.nextInt();

                // Calculate and display expiry date
                calculateWarrantyExpiry(purchaseDate, years, months);

            } catch (Exception e) {
                System.out.println("Invalid input! Please make sure to enter correct values.");
            }

            System.out.print("Check another warranty? (Y/N): ");
            again = scanner.next().charAt(0);
            scanner.nextLine(); // Clear buffer

        } while (again == 'Y' || again == 'y');

        System.out.println("Thank you!");
        scanner.close();
    }
}


/*
Enter purchase date (yyyy-MM-dd): 2022-06-15
Enter warranty period in years: 2
Enter warranty period in months: 6
Purchase Date       : 2022-06-15
Warranty Period     : 2 years, 6 months
Warranty Expiry Date: 2025-12-15
Check another warranty? (Y/N): n
Thank you!

*/