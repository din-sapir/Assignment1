public abstract class Account implements IAccount{

    //state
    protected int accountNumber;
    protected double balance;

    //constructor
    public Account(int accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    //behavior
    @Override
    public void Deposit(double amount) {
    balance += amount;
    }

    @Override
    public abstract double Withdraw(double amount);

    @Override
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    public int GetAccountNumber() {
        return accountNumber;
    }
}