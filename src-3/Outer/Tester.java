package Outer;

import bankning_system.ATM;
import bankning_system.Bank;

public class Tester {
    public static void main(String[] args) {

        Bank someBank = new Bank();
        ATM someAtm = new ATM();
        someBank.attachATM(someAtm);

        Customer someCustomer = new Customer(someBank, someAtm);
        Customer someCustomer2 = new Customer(someBank, someAtm);

        someCustomer.openAccount();
        System.out.println(someCustomer.getAccountNum());

        someCustomer.depositMoney(19998900);
        System.out.println(someCustomer.checkBalance());
        someCustomer2.openAccount();
        someCustomer2.depositMoney(19998);
        System.out.println(someCustomer2.checkBalance());
    }
}

