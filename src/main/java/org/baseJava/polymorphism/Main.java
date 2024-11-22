package org.baseJava.polymorphism;

import org.baseJava.polymorphism.taxes.TaxEarnings;
import org.baseJava.polymorphism.taxes.TaxEarningsMinusSpendings;
import org.baseJava.polymorphism.taxes.TaxSystem;

public class Main {

    public static void main(String[] args) {
        TaxSystem taxSystemEarnings = new TaxEarnings();
        TaxSystem taxSystemEarningsMinusSpendings = new TaxEarningsMinusSpendings();

        Sale sale = new Sale("TV", 3500);
        Sale sale1 = new Sale("computer", 4800);
        Expenditure expenditure = new Expenditure("chair", 250);
        Expenditure expenditure1 = new Expenditure("roses", 100);
        Deal[] deals = {sale, sale1, expenditure, expenditure1};

        Company company = new Company("Oracle", taxSystemEarnings);
        int[] amount = {1500, -500, 0, -900};
        company.shiftMoney(amount);
        System.out.println("\nНалог по taxSystemEarnings");
        System.out.println("Разница доходов и расходов: " + company.applyDeals(deals));

        company.setTaxSystem(taxSystemEarningsMinusSpendings);
        company.shiftMoney(amount);
        System.out.println("\nНалог по taxSystemEarningsMinusSpendings");
        System.out.println("Разница доходов и расходов : " + company.applyDeals(deals));
    }
}
