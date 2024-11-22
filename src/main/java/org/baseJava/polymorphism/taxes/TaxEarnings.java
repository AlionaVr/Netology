package org.baseJava.polymorphism.taxes;

public class TaxEarnings extends TaxSystem {
    @Override
    public int calcTaxFor(int debit, int credit) {
        int tax = debit * 6 / 100;
        return Math.max(tax, 0);
    }
}
