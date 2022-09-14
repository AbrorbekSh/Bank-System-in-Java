package Outer;

import bankning_system.ATM;
import bankning_system.Bank;

public class Customer {
    private Bank bank;
    private ATM atm;
    private int accountNumber;

    public Customer(Bank bank, ATM atm) {
        this.atm = atm;
        this.bank = bank;
    }

    public void openAccount() {
        accountNumber = bank.createAccount();
    }

    public void depositMoney(int amount) {
        if(atm.loginToAccount(accountNumber)){
            atm.deposit(amount);
            atm.logout();
        }
    }

    public void withdrawMoney(int amount) {
        if(atm.loginToAccount(accountNumber)){
            atm.withdraw(amount);
            atm.logout();
        }
    }

    public int checkBalance() {
        if(atm.loginToAccount(accountNumber)){
            int out = atm.getBalance();
            atm.logout();
            return out;
        }
        return -1;
    }

    public int getAccountNum() {
        return accountNumber;
    }
}
