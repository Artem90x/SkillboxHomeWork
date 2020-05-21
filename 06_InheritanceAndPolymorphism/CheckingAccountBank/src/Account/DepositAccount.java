package Account;
import java.time.LocalDate;

public class DepositAccount extends MainAccount {

    private LocalDate lastCashInDate = LocalDate.now();

    public DepositAccount(double amount) {
        super(amount);
    }

    @Override
    public void cashReplenish(double amount) {
        super.cashReplenish(amount);
        lastCashInDate = LocalDate.now();
    }

    @Override
    public void cashOut(double amount) {
        if (LocalDate.now().isAfter(lastCashInDate.plusMonths(1))) {
            super.cashOut(amount);
        } else {
            System.out.println("Период блокировки не истек!");
        }
    }
    public void setLastCashInDate(LocalDate date) {
        lastCashInDate = date;
    }
}
