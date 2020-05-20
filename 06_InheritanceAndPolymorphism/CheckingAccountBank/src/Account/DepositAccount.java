package Account;


public class DepositAccount extends MainAccount {

    public DepositAccount(double amount) {
        super(amount);
        super.cashReplenish2(amount);
        super.cashOutDep(amount);
    }
}
