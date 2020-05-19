package Account;

public class CardAccount extends MainAccount {
    public CardAccount(double amount) {
        super(amount);
    }

    @Override
    public void cashOut(double amount) {
        setAmount(getAmount() - (amount * 1.01));
    }
}
