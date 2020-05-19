package Account;

public class MainAccount {
    private double amount = 0.0;

    public MainAccount(double amount) {
        setAmount(amount);
    }

    public double getAmount() {
        return amount;
    }

    protected void setAmount(double amount) {
        if (amount > 0) {
            this.amount = amount;
        } else {
            System.out.println("Ошибка! Баланс не может быть отрицательным");
        }
    }

    public void cashReplenish(double amount) {
        setAmount(getAmount() + amount);
    }
    public void cashOut(double amount) {
        setAmount(getAmount() - amount);
    }
}
