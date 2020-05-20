package Account;

public class CardAccount extends MainAccount {
    public CardAccount(double amount) {
        super(amount);
        super.cashOutCard(amount);
    }
}
