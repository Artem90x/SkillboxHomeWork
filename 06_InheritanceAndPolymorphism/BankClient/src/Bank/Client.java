package Bank;

public abstract class Client {
    protected double balance;

    public void addMoney(Double amount) {
        balance += amount;
    }

    public void cashOut(Double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }

    public double getBalance() {

        return balance;
    }
}
