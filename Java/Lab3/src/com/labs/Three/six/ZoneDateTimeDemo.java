package com.labs.Three.six;
/*
3.6 : Create a method which accept zone id and print the current date and time with respect to
given zone. (Hint: Few zones to test your code. America/New_York, Europe/London, Asia/Tokyo,
US/Pacific, Africa/Cairo, Australia/Sydney etc.)
 */
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.Scanner;

public class ZoneDateTimeDemo {

    public static void displayDateTimeByZone(String zoneIdStr) {
        try {
            ZoneId zoneId = ZoneId.of(zoneIdStr);
            ZonedDateTime zonedDateTime = ZonedDateTime.now(zoneId);
            System.out.println("Current date and time in " + zoneIdStr + " : " + zonedDateTime);
        } catch (Exception e) {
            System.out.println("Invalid Zone ID. Please try again.");
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char again;

        do {
            System.out.print("Enter Zone ID (e.g., America/New_York, Asia/Tokyo): ");
            String zoneInput = scanner.nextLine();

            displayDateTimeByZone(zoneInput);

            System.out.print("Try another zone? (Y/N): ");
            again = scanner.next().charAt(0);
            scanner.nextLine(); // Clear buffer

        } while (again == 'Y' || again == 'y');

        System.out.println("Done. Have a great day!");
        scanner.close();
    }
}


/*
Enter Zone ID (e.g., America/New_York, Asia/Tokyo): Europe/London
Current date and time in Europe/London : 2025-07-23T09:49:00.123+01:00[Europe/London]
Try another zone? (Y/N): y
Enter Zone ID (e.g., America/New_York, Asia/Tokyo): US/Pacific
Current date and time in US/Pacific : 2025-07-23T01:49:00.123-07:00[US/Pacific]
Try another zone? (Y/N): n
Done. Have a great day!


*/