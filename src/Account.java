/*
This is the General Account class which will be inherited by all other Account classes so that we don't need to repeat
behaviors and states that are identical for all types of accounts. For this reason the class is an abstract and
implements the IAccount interface.
*/
public abstract class Account implements IAccount{

    //state
    /*
    Account number identifies the account in a unique manner
    Balance stores the current account balance, starting at 0
    */
    protected int accountNumber;
    protected double balance;

    //constructor
    /*
    Initializing every account with a balance of 0 and an account number given in the main class
    */
    public Account(int accountNumber){
        this.accountNumber = accountNumber;
        this.balance = 0.0;
    }

    //behavior
    @Override
    /*
    Deposits a specified amount into the balance as long as it is a positive deposit, otherwise prints a message
    indicating that this is not a possible deposit quantity
    */
    public void Deposit(double amount) {
        if (amount > 0) {
            balance += amount;
        } else {
            System.out.println("Insufficient Deposit");
        }
    }

    @Override
    /*
    This behavior was made abstract as each account class has different limitations and restrictions
    */
    public abstract double Withdraw(double amount);

    @Override
    /*
    This behavior returns the current balance
    */
    public double GetCurrentBalance() {
        return balance;
    }

    @Override
    /*
    This behavior returns the account number for the specific account
    */
    public int GetAccountNumber() {
        return accountNumber;
    }
}