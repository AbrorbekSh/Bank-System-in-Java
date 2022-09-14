package bankning_system;
import java.util.ArrayList;

public class Bank {

    private ArrayList<Accounts> accounts = new ArrayList<Accounts>();

    public int createAccount() {
        int id = 1001+accounts.size();
        Accounts newAccount = new Accounts(id, 0);
        accounts.add(newAccount);
        return id;
    }

    public void attachATM(ATM atm) {
        atm.setBank(this);
    }

    public int accessAcctInfo(int acctNum){
        if(accounts.size()<acctNum-1001){
            throw new RuntimeException("no corresponding Account in the Bank");
        }
        return accounts.get(acctNum-1001).getBalance();
    }

    public void updateAcctBal(int acctNum, int diff){
        if(accounts.size()<acctNum-1001){
            throw new RuntimeException("No corresponding account in the Bank");
        } else if(accounts.get(acctNum-1001).getBalance() + diff < 0){
            throw new RuntimeException("The resulting balance will be negative");
        } else {
            accounts.get(acctNum-1001).changeBalance(diff);
        }
    }

    public int getAccBal(int accNum) {
        if(accounts.size()<accNum-1001){
            throw new RuntimeException("No corresponding account in the Bank");
        } else {
            return accounts.get(accNum-1001).getBalance();
        }
    }
}
