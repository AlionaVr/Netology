package org.polymorphism;

import org.polymorphism.taxes.TaxEarnings;
import org.polymorphism.taxes.TaxEarningsMinusSpendings;
import org.polymorphism.taxes.TaxSystem;

public class Main {

    public static void main(String[] args) {


        Company company = new Company("Oracle", new TaxSystem());
        company.shiftMoney(1500);
        company.shiftMoney(-500);
        company.shiftMoney(0);
        company.shiftMoney(-900);

        Sale sale = new Sale("TV", 3500);
        Sale sale1 = new Sale("computer", 4800);
        Expenditure expenditure = new Expenditure("chair", 250);
        Expenditure expenditure1 = new Expenditure("roses", 100);
        Deal[] deals = {sale, sale1, expenditure, expenditure1};


        TaxSystem taxSystemEarnings = new TaxEarnings();
        TaxSystem taxSystemEarningsMinusSpendings = new TaxEarningsMinusSpendings();

        System.out.println("Разница доходов и расходов: " + company.applyDeals(deals, taxSystemEarnings, taxSystemEarningsMinusSpendings));


    }
}
