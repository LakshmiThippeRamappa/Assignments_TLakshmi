package com.labs.Four.Two;
public class Account {
    private static long accCounter = 1000;

    protected long accNum;
    protected double balance;
    protected Person accHolder;

    public Account(double balance, Person accHolder) {
        this.accNum = ++accCounter;
        this.balance = balance;
        this.accHolder = accHolder;
    }

    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Deposited ₹" + amount);
        }
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && balance - amount >= 500) {
            balance -= amount;
            return true;
        }
        return false;
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
        return "Account No: " + accNum + "\n" + accHolder + "\nBalance: ₹" + balance;
    }
}
