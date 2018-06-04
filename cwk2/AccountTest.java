
import java.util.ArrayList;
import java.util.List;

/**
 * Program that tests the different bank accounts
 *
 * <p>
 * Created for COMP1721 Coursework 2.</p>
 *
 * @author Slavyana Dianova Chervenkondeva
 */
public class AccountTest {

    public static void main(String[] args) {
        List<BankAccount> accounts = new ArrayList<>();

        // Successful account creation
        System.out.println("Creating bank accounts...\n");
        BankAccount b1 = new BankAccount(1000, "Emma Swan", 1000);
        BankAccount b2 = new BankAccount(2000, "Jon Snow");
        BankAccount b3 = new BankAccount(3000, "Walter White", 10000);

        System.out.println("Creating savings accounts...\n");
        SavingsAccount s1 = new SavingsAccount(4040, "Sheldon Cooper", 4500, 1.5);
        SavingsAccount s2 = new SavingsAccount(5555, "Barney Stinson", 7000, 2.3);
        SavingsAccount s3 = new SavingsAccount(6600, "Chandler Bing", 0.75);

        System.out.println("Creating student accounts...\n");
        StudentAccount p1 = new StudentAccount(7001, "Mike Wheeler", 11);
        StudentAccount p2 = new StudentAccount(8800, "Hannah Baker");
        StudentAccount p3 = new StudentAccount(9900, "Rachel Zane", 2000);

        // Adding the accounts to the list
        System.out.println("Adding accounts to the list...\n");
        accounts.add(b1);
        accounts.add(b2);
        accounts.add(b3);
        accounts.add(s1);
        accounts.add(s2);
        accounts.add(s3);
        accounts.add(p1);
        accounts.add(p2);
        accounts.add(p3);

        // Printing out the account
        System.out.println("Printing out account information...\n");
        for (BankAccount account : accounts) {
            System.out.println(account);
        }

        // Testing the deposit method
        System.out.println("Depositing 200...\n");
        for (BankAccount account : accounts) {
            account.deposit(200);
            System.out.println(account);
        }

        // Testing the withdraw method
        System.out.println("Withdrawing 50...\n");
        for (BankAccount account : accounts) {
            account.withdraw(50);
            System.out.println(account);
        }

        // Applying interest
        System.out.println("Applying interest to savings accounts...\n");
        for (BankAccount account : accounts) {
            if (account instanceof SavingsAccount) {
                ((SavingsAccount) account).applyInterest();
                System.out.println(account);
            }
        }

        // Testing overdraft
        System.out.println("Checking overdraft...\n");
        p2.setBalance(0);
        p2.withdraw(250);
        System.out.println(p2);

        // Testing invalid operations
        // Creation
        System.out.println("Creating a savings account with over 10000...\n");
        try {
            accounts.add(new SavingsAccount(0, "Bad Luck", 10001, 2));
        } catch (Exception e) {
            System.out.println("Account can't be created. Balance over 10000.");
        }

        System.out.println("Creating an account with over balance less than 0...\n");
        try {
            accounts.add(new StudentAccount(0, "Bad Luck", -3));
        } catch (Exception e) {
            System.out.println("Account can't be created. Balance under 0.");
        }

        // Withdrawing
        System.out.println("Withdrawing too much money...\n");
        try {
            s3.withdraw(30000);
        } catch (Exception e) {
            System.out.println("Not enough money in account.");
        }

        System.out.println("Withdrawing a negative amount...\n");
        try {
            p2.withdraw(-1);
        } catch (Exception e) {
            System.out.println("Amount must be over 0.");
        }

        System.out.println("Having overdraft over 250...\n");
        try {
            p2.setBalance(0);
            p2.withdraw(251);
        } catch (Exception e) {
            System.out.println("You have exceeded your overdraft.");
        }

        // Depositing
        System.out.println("Depositing 0...");
        try {
            s2.deposit(0);
        } catch (Exception e) {
            System.out.println("Amount must be over 0.");
        }
        
        System.out.println("Depositing to a savings account...");
        try {
            s2.setBalance(0);
            s2.deposit(10001);
        } catch (Exception e) {
            System.out.println("Balance is over 10000.");
        }
        
    }

}
