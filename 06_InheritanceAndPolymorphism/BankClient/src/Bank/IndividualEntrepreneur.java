package Bank;

public class IndividualEntrepreneur extends Client {
    private static double SUM_COMMISSION = 1000.0;
    private static double MIN_COMMISSION = 0.005;
    private static double MAX_COMMISSION = 0.01;

    @Override
    public void addMoney(Double amount) {

        if (amount < SUM_COMMISSION) {
            balance += amount * (1 - MAX_COMMISSION);
        } else {
            balance += amount * (1 - MIN_COMMISSION);
        }
    }

    @Override
    public void cashOut(Double amount) {
        if (amount <= balance) {
            balance -= amount;
        }
    }
}
