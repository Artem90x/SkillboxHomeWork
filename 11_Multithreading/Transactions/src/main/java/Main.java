import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    private static final int THREAD_COUNT = 4;

    public static void main(String[] args) throws InterruptedException {

        HashMap<String, Account> accounts = new HashMap<>();
        for (int i = 1; i <= 100; i++) {
            String accNumber = String.valueOf(i);
            long money = Math.round(100000 * Math.random());
            Account acc = new Account();
            acc.setAccNumber(accNumber);
            acc.setMoney(money);
            accounts.put(accNumber, acc);
        }
        Bank bank = new Bank(accounts);

        long beforeBalance = 0;
        for (int j = 1; j <= accounts.size(); j++) {
            beforeBalance += bank.getBalance(String.valueOf(j));
        }
        System.out.println("Баланс до переводов: " + beforeBalance);

        ArrayList<Thread> threads = new ArrayList<>();
        for (int k = 0; k < THREAD_COUNT; k++) {
            int threadNumber = k + 1;
            threads.add(new Thread(() -> {
                long start = System.currentTimeMillis();
                long finish = System.currentTimeMillis() - start;
                int anyNumber = (int) Math.round(99 * Math.random());
                String accFrom = String.valueOf(anyNumber);
                String accTo = String.valueOf(anyNumber + 1);
                long amount = (long) (50000 * Math.random());
                try {
                    bank.transfer(accFrom, accTo, amount);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Поток " + threadNumber + " окончен: " + finish + " ms");
            }));
        }
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }

        long afterBalance = 0;
        for (int n = 1; n <= accounts.size(); n++) {
            afterBalance += bank.getBalance(String.valueOf(n));
        }
        System.out.println("Баланс после переводов: " + afterBalance);
    }
}
