package com.labs.Four.Two;
public class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(double balance, Person accHolder, double overdraftLimit) {
        super(balance, accHolder);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public boolean withdraw(double amount) {
        if (balance - amount >= -overdraftLimit) {
            balance -= amount;
            System.out.println("Current Account Withdrawn ₹" + amount);
            return true;
        } else {
            System.out.println("Cannot withdraw ₹" + amount + " — Overdraft limit ₹" + overdraftLimit + " exceeded.");
            return false;
        }
    }
}