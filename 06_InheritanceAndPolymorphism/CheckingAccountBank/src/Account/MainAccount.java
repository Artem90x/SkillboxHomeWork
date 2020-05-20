package Account;

import java.time.LocalDate;

public class MainAccount {
    private LocalDate lastCashInDate = LocalDate.now();
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
        } else  {
            System.out.println("Ошибка! Баланс не может быть отрицательным");
        }
    }

    public void cashReplenish(double amount) {
        setAmount(getAmount() + amount);
    }
    public void cashReplenish2(double amount) {
        setAmount(getAmount() - amount);
        lastCashInDate =LocalDate.now();
    }
    public void cashOut(double amount) {
        setAmount(getAmount() - amount);
    }
    public void cashOutCard(double amount) {
        setAmount(getAmount() - amount * 1.01);
    }
    public void cashOutDep(double amount) {
        if (LocalDate.now().isAfter(lastCashInDate.plusMonths(1))) {
            cashOut(amount);
        } else {
            System.out.println("Период блокировки не истек!");
        }
    }
    public void setLastCashInDate(LocalDate date) {
        lastCashInDate = date;
    }
}
