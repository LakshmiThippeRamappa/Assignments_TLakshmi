package com.labs.Four.One;

public class Account {
    private static long accCounter = 1000;

    private long accNum;
    private double balance;
    private Person accHolder;

    public Account(double balance, Person accHolder) {
        this.accNum = ++accCounter;
        this.balance = balance;
        this.accHolder = accHolder;
    }

    // Deposit method
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount + " successfully.");
        } else {
            System.out.println("Deposit amount must be positive.");
        }
    }
    
    // Withdraw method (with minimum balance check)
    public void withdraw(double amount) {
        if (amount > 0 && (balance - amount) >= 500) {
            balance -= amount;
            System.out.println("Withdrew ₹" + amount + " successfully.");
        } else {
            System.out.println("Cannot withdraw ₹" + amount + ". Minimum balance ₹500 must be maintained.");
        }
    }

    public double getBalance() {
        return balance;
    }

    public long getAccNum() {
        return accNum;
    }

    public Person getAccHolder() {
        return accHolder;
    }

    @Override
    public String toString() {
        return "Account Number: " + accNum + "\nHolder: " + accHolder + "\nBalance: ₹" + balance;
    }
}
