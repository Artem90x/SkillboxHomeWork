package Bank;

public abstract class Client {
    protected double balance;
    String name;

    public Client(String name) {
        this.name = name;
    }

    public void addMoney(Double amount) {
        balance += amount;
    }

    public void cashOut(Double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public String getName() {
        return name;
    }

    public double getBalance() {

        return balance;
    }
}
