package week04;

/**
 * This class represents Bank Accounts with a balance in CAD and a account number
 *
 * Account numbers are currently not implemented. More on lecture 09
 *
 * @author Juliano Franz
 */
public class BankAccount {
    private double accountBalance;
    private int accountNumber;

    /**
     * Creates a new bank account given a starting balance
     * @param initialBalance the starting balance
     */
    public BankAccount(double initialBalance){
        accountBalance = initialBalance;
        accountNumber = 0;
    }

    /**
     * Creates a new bank account with starting balance of 0 CAD
     */
    public BankAccount(){
        this(0);
    }

    public double getAccountBalance(){
        return accountBalance;
    }

    /**
     * Deposit money into the account.
     * @param amount the amount to be deposited. The value MUST be positive.
     */
    public void deposit(double amount){
        if(amount > 0) {
            accountBalance += amount;
        }
    }

    /**
     * Withdraw money from the bank account if the account has enough balance
     * @param amount the amount of money we want to withdraw (CAD).
     *               Amount must be positive
     * @return true if there was enough money; false otherwise. Returns false if amount is negative
     */
    public boolean withdraw(double amount){
        if(amount <0){
            return false;
        }

        if(accountBalance < amount) {
            return false;
        }
        accountBalance -= amount;
        return true;
    }




}
