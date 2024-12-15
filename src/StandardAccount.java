public class StandardAccount extends Account {

    //state
    protected double creditLimit;

    //constructor
    public StandardAccount(int accountNumber,double creditLimit) {
        super(accountNumber);
        if (creditLimit < 0) {
            this.creditLimit = creditLimit;
        }
        else {
            this.creditLimit = 0;
            }
    }

    //behavior
    @Override
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