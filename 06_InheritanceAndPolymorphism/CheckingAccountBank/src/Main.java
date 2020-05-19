import Account.CardAccount;
import Account.DepositAccount;
import Account.MainAccount;

import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        MainAccount Tom = new MainAccount(100000.0);
        System.out.println("Ваш баланс: " + Tom.getAmount());
        Tom.cashReplenish(50000.0);
        System.out.println(Tom.getAmount());
        Tom.cashOut(45000.0);
        System.out.println(Tom.getAmount());
        Tom.cashOut(200000);
        System.out.println("На балансе: " + Tom.getAmount() +
                "\n==================================\n");

        DepositAccount depositTom = new DepositAccount(200000.);
        System.out.println("Депозитарный расчётный счёт");
        depositTom.cashOut(50000.);
        System.out.println(depositTom.getAmount());
        depositTom.setLastCashInDate(LocalDate.of(2020,4,18));
        depositTom.cashOut(30000.);
        System.out.println("На балансе: " + depositTom.getAmount() +
                "\n==================================\n");

        CardAccount cardTom = new CardAccount(50000.);
        System.out.println("Карточный счёт");
        cardTom.cashOut(30000.);
        System.out.println("Баланс карты: "+ cardTom.getAmount());
    }
}
