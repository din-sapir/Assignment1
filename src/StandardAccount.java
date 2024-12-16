/*
This class is a standard account that inherits from the general account class in addition to having limitations
of credit limit that change the process of the "withdraw" behavior
*/
public class StandardAccount extends Account {

    //state
    /*
    The credit limit defines the minimal value the balance can achieve
    */
    protected double creditLimit;

    //constructor
    /*
    Initializes the standard account with a credit limit provided by the main class. If the credit limit provided is
    positive it will be replaced with 0 as the credit limit
    */
    public StandardAccount(int accountNumber,double creditLimit) {
        super(accountNumber); //Inherits this value from the parent account class
        if (creditLimit < 0) {
            this.creditLimit = creditLimit;
        }
        else {
            this.creditLimit = 0;
            }
    }

    //behavior
    @Override
    /*
    For the standard account the "withdraw" behavior will not withdraw more than possible (balance minus credit limit)
    If the amount requested is greater than possible the amount withdrawn will be the maximum possible and the balance
    will be changed to the credit limit, otherwise the amount requested will be withdrawn and the balance will change
    accordingly
    */
    public double Withdraw(double amount) {
        double maxWithdraw = balance - creditLimit;
        if ( maxWithdraw < amount) {
            balance = creditLimit;
            return maxWithdraw;
        } else {
            balance -= amount;
            return amount;
        }
    }
}