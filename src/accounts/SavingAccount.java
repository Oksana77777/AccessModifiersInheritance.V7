package accounts;

public class SavingAccount extends Account {
    private double accountAPY = 1.2;
    private double minimumAccountBalance;

    public SavingAccount(String accountOwnerName, double accountBalance, double minimumAccountBalance) {
        this.accountOwnerName = accountOwnerName;
        this.accountBalance = accountBalance;
        this.minimumAccountBalance = minimumAccountBalance;
    }

    @Override
    public boolean pay(double amount) {
        if (amount > (accountBalance - minimumAccountBalance)) {
            return false;
        } else {
            accountBalance += amount;
            return true;
        }
    }

    @Override
    public boolean transfer(Account account, double amount) {
        if ((amount <= (accountBalance - minimumAccountBalance)) && account.add(amount)) {
            accountBalance += amount;
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

                        SAVING Account
                        Account owner: %20s
                        Account balance: $%,(17.2f  Annual Percentage Yield: %5.2f%% Minimum balance: $%5.0f""",
                this.accountOwnerName, this.accountBalance, this.accountAPY, this.minimumAccountBalance);
    }

    public String getAccountOwnerName() {
        return this.accountOwnerName;
    }

    public double getAccountBalance() {
        return this.accountBalance;
    }
}
