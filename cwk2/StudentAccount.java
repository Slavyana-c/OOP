
/**
 * A single student account
 *
 * <p>
 * Created for COMP1721 Coursework 2.</p>
 *
 * @author Slavyana Dianova Chervenkondeva
 */
public class StudentAccount extends BankAccount {

    // Student account constructors
    public StudentAccount(int id, String name, int bal) {
        super(id, name, bal);
    }

    public StudentAccount(int id, String name) {
        super(id, name);
    }

    // Withdraws money from the deposit, allows overdraft of 250
    @Override
    public void withdraw(int amount) throws IllegalArgumentException {
        if (amount > 0 && balance - amount >= -250) {
            balance -= amount;

        } else {
            throw new IllegalArgumentException("Invalid amount");
        }
    }

    // Returns a string with the account information
    @Override
    public String toString() {
        return String.format("Account type: Student Account\n"
                + "Name: %s\n"
                + "ID: %d\n"
                + "Balance: %d\n", name, id, balance);
    }

}
