package com.labs.Three.Three;
/*
3.3 : Create a method to accept date and print the duration in days, months and years with
regards to current system date.
 */

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DateDurationCalculator {

    // Method to calculate duration between input date and current date
    public static void calculateDuration(String dateInput) {
        try {
            // Parse input date
            LocalDate inputDate = LocalDate.parse(dateInput);  // Format: yyyy-MM-dd
            LocalDate currentDate = LocalDate.now();

            // Calculate period
            Period period = Period.between(inputDate, currentDate);

            // Display result
            System.out.println("Duration from " + inputDate + " to " + currentDate + ":");
            System.out.println("Years: " + period.getYears());
            System.out.println("Months: " + period.getMonths());
            System.out.println("Days: " + period.getDays());
        } catch (Exception e) {
            System.out.println("Invalid date format. Please enter in yyyy-MM-dd format.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char again;

        do {
            System.out.print("Enter a date (yyyy-MM-dd): ");
            String inputDate = scanner.nextLine();

            calculateDuration(inputDate);

            System.out.print("Check another date? (Y/N): ");
            again = scanner.next().charAt(0);
            scanner.nextLine(); // clear buffer

        } while (again == 'Y' || again == 'y');

        System.out.println("Thanks!");
        scanner.close();
    }
}

/*
Enter a date (yyyy-MM-dd): 2020-07-23
Duration from 2020-07-23 to 2025-07-23:
Years: 5
Months: 0
Days: 0
Check another date? (Y/N): n
Thanks!

*/