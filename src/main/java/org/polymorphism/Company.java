package org.polymorphism;

import org.polymorphism.taxes.TaxSystem;

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

    public void shiftMoney(int amount) {
        debit += Math.max(amount, 0);
        credit += (amount < 0) ? Math.abs(amount) : 0;
    }

    public void payTaxes() {
        System.out.printf("Компания %s уплатила налог в размере: %d руб.\n",
                title,
                taxSystem.calcTaxFor(debit, credit));
        debit = 0;
        credit = 0;
    }

    int applyDeals(Deal[] deals, TaxSystem ts1, TaxSystem ts2) {
        for (Deal deal : deals) {
            debit += deal.debitChange;
            credit += deal.creditChange;
        }
        int difference = debit - credit;
        setTaxSystem(chooseBestTaxSystem(ts1, ts2));
        payTaxes();
        return difference;
    }

    public TaxSystem chooseBestTaxSystem(TaxSystem ts1, TaxSystem ts2) {
        int tax1 = ts1.calcTaxFor(debit, credit);
        int tax2 = ts2.calcTaxFor(debit, credit);
        System.out.println("Налог по SystemEarning: " + tax1);
        System.out.println("Налог по SystemEarningsMinusSpendings: " + tax2);
        return tax1 < tax2 ? ts1 : ts2;
    }
}
