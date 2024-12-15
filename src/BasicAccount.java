public class BasicAccount extends Account {

    //state
    protected double withdrawalLimit;

    //constructor
    public BasicAccount(int accountNumber, double withdrawalLimit) {
        super(accountNumber);
        this.withdrawalLimit = withdrawalLimit;
    }

    //behavior
    @Override
    public double Withdraw(double amount) {
        double minimal = Math.min(balance, withdrawalLimit);
        balance -= Math.min(minimal, amount);
        return Math.min(minimal, amount);
    }
}