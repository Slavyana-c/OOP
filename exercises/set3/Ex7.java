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

public class Ex7 {

    public static void main(String[] args) {
        BankAccount p1 = new BankAccount(1234, "Anna", 20000);
        p1.withdraw(2500);
        p1.deposit(4500);
        
        System.out.println("id: " + p1.getId());
        System.out.println("name: " + p1.getName());
        System.out.println("balance after withdraw and deposit: " + p1.getBalance());
    }
}
