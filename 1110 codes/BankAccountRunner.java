package week04;

public class BankAccountRunner {
    public static void main(String[] args) {
        BankAccount bankAccount = new BankAccount(10);
        BankAccount bankAccount2 = new BankAccount(10);

        bankAccount.withdraw(100);

        if(bankAccount.equals(bankAccount2)){
            System.out.println("They are the same");
        }

        String bcString = bankAccount.toString();
        System.out.println(bankAccount);
    }
}
