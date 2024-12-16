/*
This class is a premium account that inherits from the general account class, this class does not have any limitations
with the withdrawal behavior, which is why there are no unique states for this account
*/
public class PremiumAccount extends Account {

    //constructor
    /*
    Initializes the premium account with the account number provided in the main class inherited by the abstract
    account class
    */
    public PremiumAccount(int accountNumber) {
        super(accountNumber); //Inherits this value from the parent account class
    }

    //behavior
    @Override
    /*
    As there are no restrictions, the new balance is the current balance substracting the withdrawal amount and the
    withdrawal amount is always as requested
    */
    public double Withdraw(double amount) {
        balance -= amount;
        return amount;
    }
}