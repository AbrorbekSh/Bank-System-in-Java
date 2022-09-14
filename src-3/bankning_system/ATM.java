package bankning_system;

public class ATM {
    private Bank bank;
    private int accountNumber = -1;

    public void setBank(Bank b) {
        this.bank = b;
    }

    public boolean loginToAccount(int accNum) {
        try {
            bank.accessAcctInfo(accNum);
            accountNumber = accNum;
            System.out.println("logged in:"+accountNumber);
            return true;
        } catch (Exception e) {
            System.out.println(e);
            return false;
        }
    }

    public boolean deposit(int amount) {
        if(accountNumber != -1) {
            try {
                bank.updateAcctBal(accountNumber, amount);
                return true;
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }

        }
        return false;
    }

    public boolean withdraw(int amount) {
        if(accountNumber != -1) {
            try {
                bank.updateAcctBal(accountNumber, -amount);
                return true;
            } catch (Exception e) {
                System.out.println(e);
                return false;
            }
        }
        return false;
    }

    public int getBalance() {
        if(accountNumber != -1) {
            return bank.getAccBal(accountNumber);
        }
        return 0;
    }

    public void logout() {
        accountNumber = -1;
    }
}