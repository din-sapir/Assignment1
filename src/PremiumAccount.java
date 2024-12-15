public class PremiumAccount extends Account {

    public PremiumAccount(int accountNumber) {
        super(accountNumber);
    }

    @Override
    public double Withdraw(double amount) {
        balance -= amount;
        return amount;
    }
}