import java.util.ArrayList;
import java.util.List;

public class Bank implements IBank {


    //state
    protected List<IAccount> accountList;

    //constructor
    public Bank() {
        this.accountList = new ArrayList<>();
    }
    //behavior
    @Override
    public void OpenAccount(IAccount account) {
        this.accountList.add(account);
    }

    @Override
    public void CloseAccount(int accountNumber) {
        for (IAccount account : accountList) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() >= 0) {
                    accountList.remove(account);
                } else {
                    System.out.println("Cannot close account " + accountNumber + " due to debt");
                }
                return;
            }
        }
    }

    @Override
    public List<IAccount> GetAllAccounts() {
        return accountList;
    }

    @Override
    public List<IAccount> GetAllAccountsInDebt() {
        List<IAccount> debtAccountList = new ArrayList<>();
        for (IAccount account: accountList) {
            if (account.GetCurrentBalance() < 0) {
                debtAccountList.add(account);
            }
        }
        return debtAccountList;
    }

    @Override
    public List<IAccount> GetAllAccountsWithBalance(double balanceAbove) {
        List<IAccount> balanceAboveAccountList = new ArrayList<>();
        for (IAccount account: accountList) {
            if (account.GetCurrentBalance() > balanceAbove) {
                balanceAboveAccountList.add(account);
            }
        }
        return balanceAboveAccountList;
    }
}
