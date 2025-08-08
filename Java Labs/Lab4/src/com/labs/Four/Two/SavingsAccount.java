package com.labs.Four.Two;

public class SavingsAccount extends Account {
    private static final double MINIMUM_BALANCE = 1000;

    public SavingsAccount(double balance, Person accHolder) {
        super(balance, accHolder);
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= MINIMUM_BALANCE) {
            balance -= amount;
            System.out.println("Savings Account Withdrawn ₹" + amount);
            return true;
        } else {
            System.out.println("Cannot withdraw ₹" + amount + " — Minimum balance ₹" + MINIMUM_BALANCE + " must be maintained.");
            return false;
        }
    }
}
