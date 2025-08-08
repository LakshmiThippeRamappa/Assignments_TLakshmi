package com.labs.Four.Two;
/*
4.2 : Extend the functionality through Inheritanceand polymorphism (Maintenance)
Inherit two classes Savings Account and Current Account from account class. Implement
the following in the respective classes.
a) Savings Account
a. Add a variable called minimum Balance and assign final modifier.
b. Override method called withdraw (This method should check for minimum
balance and allow withdraw to happen)
b) Current Account
a. Add a variable called overdraft Limit
b. Overridemethod called withdraw (checks whether overdraft limit is reached
and returns a boolean value accordingly).
 */

public class BankApp {
    public static void main(String[] args) {
        Person smith = new Person("Smith", 30);
        Person kathy = new Person("Kathy", 28);

        // Create a SavingsAccount with ₹3000
        SavingsAccount savings = new SavingsAccount(3000, smith);
        savings.withdraw(2200); // Should work
        savings.withdraw(1000); // Should fail

        System.out.println("\n" + savings);

        // Create a CurrentAccount with ₹2000 and overdraft limit ₹1500
        CurrentAccount current = new CurrentAccount(2000, kathy, 1500);
        current.withdraw(3000); // Allowed (overdraft used)
        current.withdraw(1000); // Should fail (overdraft limit exceeded)

        System.out.println("\n" + current);
    }
}

/*
Savings Account Withdrawn ₹2200
Cannot withdraw ₹1000 — Minimum balance ₹1000.0 must be maintained.

Account No: 1001
Name: Smith, Age: 30.0
Balance: ₹800.0

Current Account Withdrawn ₹3000
Cannot withdraw ₹1000 — Overdraft limit ₹1500.0 exceeded.

Account No: 1002
Name: Kathy, Age: 28.0
Balance: ₹-1000.0

*/