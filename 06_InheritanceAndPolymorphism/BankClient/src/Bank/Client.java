package Bank;

public abstract class Client {
    protected double balance;

    public abstract void addMoney(Double amount);

    public abstract void cashOut(Double amount);

    public double getBalance() {
        return balance;
    }
}
