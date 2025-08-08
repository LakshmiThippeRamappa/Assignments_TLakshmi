package com.labs.Three.Four;

/*
3.4 : Revise exercise 3.3 to accept two LocalDates and print the duration between dates in days,
months and years.
*/

import java.time.LocalDate;
import java.time.Period;
import java.util.Scanner;

public class DateDurationBetweenTwoDates {
    public static void calculateDuration(String startDateStr, String endDateStr) {
        try {
            // Parse input strings to LocalDate
            LocalDate startDate = LocalDate.parse(startDateStr); // Format: yyyy-MM-dd
            LocalDate endDate = LocalDate.parse(endDateStr);     // Format: yyyy-MM-dd

            // Swap if startDate is after endDate
            if (startDate.isAfter(endDate)) {
                LocalDate temp = startDate;
                startDate = endDate;
                endDate = temp;
            }

            // Calculate period
            Period period = Period.between(startDate, endDate);

            // Display result
            System.out.println("Duration from " + startDate + " to " + endDate + ":");
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
            System.out.print("Enter the first date (yyyy-MM-dd): ");
            String date1 = scanner.nextLine();

            System.out.print("Enter the second date (yyyy-MM-dd): ");
            String date2 = scanner.nextLine();

            calculateDuration(date1, date2);

            System.out.print("Check another pair of dates? (Y/N): ");
            String response = scanner.nextLine();
            again = response.isEmpty() ? 'N' : response.charAt(0);

        } while (again == 'Y' || again == 'y');

        System.out.println("Thank you!");
        scanner.close();
    }
}

/*
Enter the first date (yyyy-MM-dd): 2020-03-9
Enter the second date (yyyy-MM-dd): 2024-04-5
Invalid date format. Please enter in yyyy-MM-dd format.
Check another pair of dates? (Y/N): y
Enter the first date (yyyy-MM-dd): 2020-09-12
Enter the second date (yyyy-MM-dd): 2023-08-12
Duration from 2020-09-12 to 2023-08-12:
Years: 2
Months: 11
Days: 0
Check another pair of dates? (Y/N): 5
Thank you!
*/