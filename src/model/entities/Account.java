package model.entities;

import model.exception.DomainException;

public class Account {

    private Integer number;
    private String holder;
    private double balance;
    private double withdrawLimit;

    public Account() {

    }

    public Account(Integer number, String holder, double balance, double withdrawLimit) {
        this.number = number;
        this.holder = holder;
        this.balance = balance;
        this.withdrawLimit = withdrawLimit;
    }

    public Integer getNumber() {
        return number;
    }

    public String getHolder() {
        return holder;
    }

    public void setHolder(String holder) {
        this.holder = holder;
    }

    public double getBalance() {
        return balance;
    }

    public double getWithdrawLimit() {
        return withdrawLimit;
    }

    public void setWithdrawLimit(double withdrawLimit) {
        this.withdrawLimit = withdrawLimit;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) throws DomainException {
        if (amount > withdrawLimit) {
            throw new DomainException("The amount exceeds withdraw limit");
        }
        if (amount > balance) {
            throw new DomainException("Not enough balance");
        }

        balance -= amount;
    }
}
