package org.baseJava.abstractions;

public class SimpleAccount extends Account {

    public SimpleAccount(long balance) {
        super(balance);
    }

    @Override
    void setBalance(long balance) {
        if (balance < 0) {
            return;
        }
        super.balance = balance;
    }

    @Override
    boolean add(long amount) {
        if (amount >= 0) {
            setBalance(getBalance() + amount);
            return true;
        } else
            return false;

    }

    @Override
    boolean pay(long amount) {
        if (amount <= getBalance()) {
            setBalance(getBalance() - amount);
            return true;
        } else return false;

    }

}


