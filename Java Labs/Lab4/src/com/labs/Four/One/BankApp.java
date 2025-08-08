package com.labs.Four.One;
/*
 4.1 : Refer the case study 1in Page No: 5 and create Account Class as shown below in class
diagram. Ensure minimum balance of INR 500 in a bank account is available.
Figure 14: Association of person with account class
a) Create Account for smith with initial balance as INR 2000 and for Kathy with initial
balance as 3000.(accNum should be auto generated).
b) Deposit 2000 INR to smith account.
c) Withdraw 2000 INR from Kathy account.
d) Display updated balances in both the account.
e) Generate toString() method.
 */

public class BankApp {
    public static void main(String[] args) {
        // Create Person objects
        Person smith = new Person("Smith", 30);
        Person kathy = new Person("Kathy", 28);

        // Create accounts
        Account smithAccount = new Account(2000, smith);
        Account kathyAccount = new Account(3000, kathy);

        // b) Deposit 2000 INR to Smith's account
        smithAccount.deposit(2000);

        // c) Withdraw 2000 INR from Kathy's account
        kathyAccount.withdraw(2000);

        // d) Display updated balances
        System.out.println("\n--- Account Details ---");
        System.out.println(smithAccount);
        System.out.println();
        System.out.println(kathyAccount);
    }
}
/*
Deposited ₹2000.0 successfully.
Withdrew ₹2000.0 successfully.

--- Account Details ---
Account Number: 1001
Holder: Name: Smith, Age: 30.0
Balance: ₹4000.0

Account Number: 1002
Holder: Name: Kathy, Age: 28.0
Balance: ₹1000.0

*/