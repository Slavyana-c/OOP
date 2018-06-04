
/**
 * A single bank account
 *
 * <p>
 * Created for COMP1721 Coursework 2.</p>
 *
 * @author Slavyana Dianova Chervenkondeva
 */
public class BankAccount {

    protected int id;
    protected String name;
    protected int balance;

    // BankAccount constructors
    public BankAccount(int id, String name) {
        this(id, name, 0);
    }

    public BankAccount(int id, String name, int bal) {
        this.id = id;
        this.name = name;
        this.balance = 0;
        if (bal != 0) {
            deposit(bal);
        }
    }

    // Returns the account id
    public int getId() {
        return id;
    }

    // Returns the account name
    public String getName() {
        return name;
    }

    // Returns the account balance
    public int getBalance() {
        return balance;
    }

    // Deposits money into the account if the amount is greater than 0
    public void deposit(int amount) throws IllegalArgumentException {
        if (amount > 0) {
            balance += amount;

        } else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    // Withdraws money from the account, if there is enough
    public void withdraw(int amount) throws IllegalArgumentException {
        if (amount > 0 && amount <= balance) {
            balance -= amount;

        } else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    // Returns a string with the account information
    @Override
    public String toString() {
        return String.format("Account type: Bank Account\n"
                + "Name: %s\n"
                + "ID: %d\n"
                + "Balance: %d\n", name, id, balance);
    }
}
