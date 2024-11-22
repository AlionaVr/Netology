package org.baseJava.abstractions;

public abstract class Account {
    long balance;

    public Account(long balance) {
        this.balance = balance;
    }

    void setBalance(long balance) {
        this.balance = balance;
    }

    long getBalance() {
        return balance;
    }

    abstract boolean add(long amount);

    abstract boolean pay(long amount);

    boolean transfer(Account account, long amount) {

        if (pay(amount)) {
            if (account.add(amount)) {
                return true;
            } else {
                add(amount);
            }
        }
        return false;
    }
}
