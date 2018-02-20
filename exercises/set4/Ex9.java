import java.util.Scanner;
import java.io.File;
import java.util.ArrayList;

class BankAccount{
    private int id;
    private String name;
    private int balance;

    public BankAccount(int id, String name){
        this(id, name, 0);
    }

    public BankAccount(int id, String name, int bal){
        setId(id);
        setName(name);
        setBalance(bal);
    }

    public void setId(int i) {
        id = i;
    }

    public void setName(String n) {
        name = n;
    }

    public void setBalance(int bal) {
        balance = bal;
    }

    public int getId(){
        return id;
    }

    public String getName(){
        return name;
    }

    public int getBalance(){
        return balance;
    }

    public boolean deposit(int amount){
        if(amount > 0) {
            balance += amount;
            return true;
        }
        else return false;
    }

        public boolean withdraw(int amount){
        if(amount > 0 && amount <= balance) {
            balance -= amount;
            return true;
        }
        else return false;
    }
}

public class Ex9 {

    public static void main(String[] args) {
      try {
        System.out.print("Input file path: ");
        Scanner in = new Scanner(System.in);
        String fileName = in.nextLine();

        ArrayList<BankAccount> accounts = new ArrayList<>();
        accounts.clear();
        Scanner input = new Scanner(new File(fileName));
        while(input.hasNextLine()){
            String record = input.nextLine();
            String[] data = record.split(",");
            BankAccount ba = new BankAccount(Integer.parseInt(data[0]), data[1],
                                              Integer.parseInt(data[2]));
            accounts.add(ba);
        }
        input.close();

          for (int i = 0; i < accounts.size() ; i++) {
            int id = accounts.get(i).getId();
            String name = accounts.get(i).getName();
            int balance = accounts.get(i).getBalance();
            System.out.printf("Id: %d, Name: %s, Balance: %d %n",id, name, balance);
          }
      }
      catch (Exception e) {
        System.out.println("Invalid data.");
      }

  }

}
