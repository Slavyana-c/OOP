
/**
 * A single savings account
 *
 * <p>
 * Created for COMP1721 Coursework 2.</p>
 *
 * @author Slavyana Dianova Chervenkondeva
 */
public class SavingsAccount extends BankAccount {

    private double interestRate;

    // Savings account constructors
    public SavingsAccount(int id, String name, double interestRate) {
        this(id, name, interestRate, 0);
    }

    public SavingsAccount(int id, String name, double interestRate, int bal) {
        super(id, name);
        setInterestRate(interestRate);
        if (bal != 0) {
            deposit(bal);
        }
    }

    // Sets the interest rate
    public void setInterestRate(double interestRate) {

        if (interestRate > 0) {
            this.interestRate = interestRate;
        } else {
            throw new IllegalArgumentException("Invalid interest rate");
        }

    }

    // Gets the interest rate
    public double getInterestRate() {
        return interestRate;
    }

    // Applies the interest on the account
    public void applyInterest() {
        balance = (int) (balance * (1 + interestRate / 100));
    }

    // Returns a string with the account information
    @Override
    public String toString() {
        return String.format("Account type: Savings Account\n"
                + "Name: %s\n"
                + "ID: %d\n"
                + "Balance: %d\n"
                + "Interest rate: %.2f\n", name, id, balance, interestRate);
    }

    // Deposits more money into the account, if it doesn't take it
    // over 10000
    @Override
    public void deposit(int amount) throws IllegalArgumentException {
        if (amount > 0 && (balance + amount) <= 10000) {
            balance += amount;

        } else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

}
