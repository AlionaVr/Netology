package org.baseJava.abstractions;

public class CreditAccount extends Account {
    int limit;

    public CreditAccount(long balance, int limit) {
        super(balance);
        this.limit = limit;
    }

    @Override
    boolean add(long amount) {
        long newBalance = getBalance() + amount;
        if (newBalance <= 0) {
            setBalance(newBalance);
            return true;
        } else
            return false;
    }

    @Override
    boolean pay(long amount) {
        if ((getBalance() - amount) > limit) {
            setBalance(getBalance() - amount);
            return true;
        } else
            return false;
    }


}
