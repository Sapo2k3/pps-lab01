package example.model;

public class SimpleBankAccountWithFee implements BankAccount {

    private BankAccount bankAccount;
    private double FEE = 1;

    public SimpleBankAccountWithFee(AccountHolder accountHolder,  double balance) {
        try{
            bankAccount = new SimpleBankAccount(accountHolder, balance);
        } catch (Exception e){
            throw new IllegalArgumentException(e.getMessage());
        }

    }

    @Override
    public double getBalance() {
        return this.bankAccount.getBalance();
    }

    @Override
    public void deposit(int userID, double amount) {
        this.bankAccount.deposit(userID, amount);
    }

    @Override
    public void withdraw(int userID, double amount) {
        this.bankAccount.withdraw(userID, amount + FEE);
    }
}
