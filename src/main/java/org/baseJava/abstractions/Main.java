package org.baseJava.abstractions;

public class Main {
    public static void main(String[] args) {
        Account myAccount = new SimpleAccount(1800);
        Account creditAccount = new CreditAccount(0, -1000);
        Account HusbandAccount = new SimpleAccount(3200);

        myAccount.add(200);
        HusbandAccount.pay(200);
        myAccount.transfer(HusbandAccount, 100);
        System.out.println("HusbandAccount " + HusbandAccount.getBalance()); //3100

        creditAccount.pay(800); //-800

        myAccount.transfer(creditAccount, 1500);
        System.out.println("creditAccount " + creditAccount.getBalance());//-800


        System.out.println("myAccount " + myAccount.getBalance());//1900

    }
}
