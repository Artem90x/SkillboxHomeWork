import junit.framework.TestCase;

import java.util.HashMap;

public class BankTest extends TestCase {

    HashMap<String, Account> accounts = new HashMap<>();

    @Override
    protected void setUp() {
        for (int i = 0; i < 100; i++){
            String accNumber = String.valueOf(i);
            long money = 100000;
            Account acc = new Account();
            acc.setAccNumber(accNumber);
            acc.setMoney(money);
            accounts.put(accNumber, acc);
        }
    }

    public void testTransfer() throws InterruptedException {
        Bank bank = new Bank(accounts);
        bank.transfer("2", "3", 10000);
        long actual2 = bank.getBalance("2");
        long expected2 = 90000;
        long actual3 = bank.getBalance("3");
        long expected3 = 110000;
        assertEquals(expected2, actual2);
        assertEquals(expected3, actual3);
    }

    public void testGetBalance(){
        Bank bank = new Bank(accounts);
        long actual = bank.getBalance("1");
        long expected = 100000;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}