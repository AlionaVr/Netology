package org.baseJava.polymorphism;

import org.baseJava.polymorphism.taxes.TaxSystem;

public class Company {
    private final String title;
    private TaxSystem taxSystem;
    private int debit = 0;
    private int credit = 0;

    public Company(String title, TaxSystem taxSystem) {
        this.title = title;
        this.taxSystem = taxSystem;
    }

    public void setTaxSystem(TaxSystem taxSystem) {
        this.taxSystem = taxSystem;
    }

    public void shiftMoney(int[] amount) {
        for (int i : amount) {
            debit += Math.max(i, 0);
            credit += (i < 0) ? Math.abs(i) : 0;
        }
    }

    public void payTaxes() {
        System.out.printf("Компания %s уплатила налог в размере: %d руб.\n",
                title,
                taxSystem.calcTaxFor(debit, credit));
        debit = 0;
        credit = 0;
    }

    int applyDeals(Deal[] deals) {
        for (Deal deal : deals) {
            debit += deal.debitChange;
            credit += deal.creditChange;
        }
        int difference = debit - credit;
        payTaxes();
        return difference;
    }


}
