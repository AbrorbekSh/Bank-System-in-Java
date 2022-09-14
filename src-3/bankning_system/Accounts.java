package bankning_system;

public class Accounts{
    private int number;
    private int balance;

    Accounts(int number, int balance){
        this.number = number;
        this.balance = balance;
    }

    public int getBalance(){
        return balance;
    }

    public void changeBalance(int diff){
        balance = balance + diff;
    }
}