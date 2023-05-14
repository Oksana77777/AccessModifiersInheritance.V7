package accounts;

public class CheckingAccount extends Account {

    public CheckingAccount(String accountOwnerName, double accountBalance) {
        this.accountOwnerName = accountOwnerName;
        this.accountBalance = accountBalance;
    }

    public CheckingAccount(String accountOwnerName) {
        this.accountOwnerName = accountOwnerName;
        this.accountBalance = 0;
    }

    @Override
    public boolean pay(double amount) {
        if (accountBalance >= amount) {
            accountBalance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean transfer(Account account, double amount) {
        if ((this.accountBalance >= amount) && (account.add(amount))) {
            this.accountBalance -= amount;
            return true;
        }
        return false;
    }

    @Override
    public boolean add(double amount) {
        accountBalance -= amount;
        return true;
    }

    @Override
    public String toString() {
        return String.format("""

                        CHECKING Account
                        Account owner: %20s
                        Account balance: $%,(17.2f""",
                this.accountOwnerName, this.accountBalance);
    }

    public String getAccountOwnerName() {
        return this.accountOwnerName;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }
}
