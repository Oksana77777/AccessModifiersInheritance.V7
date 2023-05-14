package accounts;

public class CreditAccount extends Account {
    public CreditAccount(String accountOwnerName, int i) {
        this.accountOwnerName = accountOwnerName;
    }

    @Override
    public boolean pay(double amount) {
        accountBalance -= amount;
        return true;
    }

    @Override
    public boolean transfer(Account account, double amount) {
        if (account.add(amount)) {
            return pay(amount);
        }
        return true;
    }

    @Override
    public boolean add(double amount) {
        if (amount - accountBalance < 0) {
            return true;
        }
        accountBalance += amount;
        return false;
    }

    @Override
    public String toString() {
        return String.format("""

                        CREDIT Account
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
