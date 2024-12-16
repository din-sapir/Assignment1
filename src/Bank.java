/*
Here are the necessary imports in order for us to use lists and arrays in the code
*/
import java.util.ArrayList;
import java.util.List;

/*
This class is the bank class which uses the IBank interface. This class manages multiple accounts and holds operations
to manage the accounts.
*/
public class Bank implements IBank {

    //state
    /*
    Here we defined the list of accounts created in the IAccount interface, thus enabling polymorphism
    */
    protected List<IAccount> accountList;

    //constructor
    /*
    Initializes the list of accounts by creating a new list
    */
    public Bank() {
        this.accountList = new ArrayList<>();
    }
    //behavior
    @Override
    /*
    This behavior of opening a new account creates a new account based on the interface by adding it to the list of
    accounts that the bank manages
    */
    public void OpenAccount(IAccount account) {
        this.accountList.add(account);
    }

    @Override
    /*
    This behavior closes an account provided only if the account exists, and has a positive balance. If the account
    number does not exist then nothing happens, if the account exists but is in debt a message is displayed, otherwise
    the account is added to a different list as an index to be closed by being removed from the account list in the
    bank after the for loop is complete to avoid errors
    */
    public void CloseAccount(int accountNumber) {
        List<IAccount> accountsToRemove = new ArrayList<>();
        for (IAccount account : accountList) {
            if (account.GetAccountNumber() == accountNumber) {
                if (account.GetCurrentBalance() >= 0) {
                    accountsToRemove.add(account);
                } else {
                    System.out.println("Cannot close account " + accountNumber + " due to debt");
                }
                break;
            }
        }
        for (IAccount accountToRemove : accountsToRemove) {
            accountList.remove(accountToRemove);
        }
    }

    @Override
    /*
    This behavior returns all the accounts in the bank by returning the account list
    */
    public List<IAccount> GetAllAccounts() {
        return accountList;
    }

    @Override
    /*
    This behavior returns all the accounts that exist within the account list as long as their current balance is
    negative, it does this by creating a new list and returning it
    */
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
    /*
    This behavior returns all the accounts that exist within the account list as long as their current balance is
    positive, it does this by creating a new list and returning it
    */
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
