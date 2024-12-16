/*
This class is a basic account that inherits from the general account class in addition to having limitations
on withdrawing that change the process of the "withdraw" behavior
*/
public class BasicAccount extends Account {

    //state
    /*
    The credit limit defines the minimal value the balance can achieve
    */
    protected double withdrawalLimit;

    //constructor
    /*
    Initializes the basic account with a withdrawal limit provided by the main class
    */
    public BasicAccount(int accountNumber, double withdrawalLimit) {
        super(accountNumber); //Inherits this value from the parent account class
        this.withdrawalLimit = withdrawalLimit;
    }

    //behavior
    @Override
    /*
    As the basic account cannot have a negative balance, the maximum withdrawal amount is the smaller number between
    the current balance and the withdrawal limit. After finding this number we check if it is smaller than the amount
    requested, based on that we know how much to withdraw from the balance.
    */
    public double Withdraw(double amount) {
        double minimal = Math.min(balance, withdrawalLimit);
        double amountToWithdraw = Math.min(minimal, amount);
        balance -= amountToWithdraw;
        return amountToWithdraw;
    }
}