package Bank;

public class IndividualEntrepreneur extends Client {
    protected static double SUM_COMMISSION = 1000.0;
    protected static double MIN_COMMISSION = 0.005;
    protected static double MAX_COMMISSION = 0.01;

    public IndividualEntrepreneur(String name) {
        super(name);
    }

    @Override
    public void addMoney(Double amount) {

        if (amount < SUM_COMMISSION) {
            super.addMoney(amount * (1 - MAX_COMMISSION));
        } else {
            super.addMoney(amount * (1 - MIN_COMMISSION));
        }
    }

    @Override
    public void cashOut(Double amount) {
        super.cashOut(amount);
    }
}
